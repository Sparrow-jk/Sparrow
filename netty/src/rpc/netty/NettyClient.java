package rpc.netty;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/23 16:47
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class NettyClient {

    private static ExecutorService executor;
    private static NettyClientHandler handler;


    //获取代理对象
    public Object getProxy(final Class<?> serviceClass, final String providerName) {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader()
                , new Class<?>[]{serviceClass}, (proxy, method, args) -> {
                    if (handler == null) {
                        initClient();
                    }
                    handler.setParameter(providerName + args[0]);
                    return executor.submit(handler).get();

                });
    }


    private static void initClient() throws InterruptedException {
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        handler = new NettyClientHandler();

        NioEventLoopGroup group = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new StringDecoder());
                        pipeline.addLast(new StringEncoder());
                        pipeline.addLast(handler);
                    }
                });

        bootstrap.connect("127.0.0.1", 8080).sync();
        System.out.println("已连接。。。");


    }

}
