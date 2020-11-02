package protocobuf;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/11 19:18
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class NettyServer {
    public static void main(String[] args) throws InterruptedException {

        //创建BossGroup 和 WorkGroup
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workGroup = new NioEventLoopGroup(4);

        try {
            //创建服务启动对象
            ServerBootstrap bootstrap = new ServerBootstrap();

            //配置启动参数
            bootstrap.group(bossGroup, workGroup) //设置两个线程组
                    .channel(NioServerSocketChannel.class)//NioServerSocketChannel 作为服务器通道实现
                    .option(ChannelOption.SO_BACKLOG, 128)//设置线程队列的连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true)//设置保持连接状态
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new ProtobufDecoder(StudentPOJO.Student.getDefaultInstance()));
                            pipeline.addLast(new NettyServerHandler());
                        }
                    });//设置 workGroup 的eventLoop的管道,及handler

            //绑定服务器端口
            ChannelFuture channelFuture = bootstrap.bind(6668).sync();

            //关闭对通道的监听
            channelFuture.channel().closeFuture().sync();
        } finally {
            //关闭
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
