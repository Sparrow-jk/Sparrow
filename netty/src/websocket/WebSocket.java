package websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/16 1:12
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class WebSocket {
    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup(4);

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ChannelPipeline pipeline = ch.pipeline();

                            //基于http编码协议。http编码解码器
                            pipeline.addLast(new HttpServerCodec());
                            //以块写入 添加chunkedWriteHandler
                            pipeline.addLast(new ChunkedWriteHandler());
                            //http 在数据传输的过程中以段传输，httpObjectAggregator来聚合 段
                            pipeline.addLast(new HttpObjectAggregator(8192));
                            //对于websocket的数据以桢的形式传输
                            //websocketFrame有六个子类
                            //websocket请求uri ws://localhost:8899/hello
                            //WebSocketServerProtocolHandler处理器将http协议转为ws协议
                            pipeline.addLast(new WebSocketServerProtocolHandler("/hello"));

                            //业务handler
                            pipeline.addLast(new WebSocketHandler());
                        }
                    });

            ChannelFuture sync = serverBootstrap.bind(8899).sync();
            sync.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
