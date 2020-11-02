package protocobuf;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufEncoder;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/11 19:53
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class NettyClient {
    public static void main(String[] args) throws InterruptedException {

        //创建事件循环组
        EventLoopGroup eventExecutors = new NioEventLoopGroup();

        try {
            //创建客户端启动对象
            Bootstrap bootstrap = new Bootstrap();

            bootstrap.group(eventExecutors)//设置线程组
                    .channel(NioSocketChannel.class)//设置客户端通道实现
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new ProtobufEncoder());
                            pipeline.addLast(new NettyClientHandler());
                        }
                    });//加入自定义handler


            //连接服务器
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 6668).sync();

            //监听通道
            channelFuture.channel().closeFuture().sync();
        } finally {
            eventExecutors.shutdownGracefully();
        }

    }
}
