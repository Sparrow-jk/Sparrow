package inboundoutbound;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/17 22:32
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class BoundClient {

    public static void main(String[] args) throws InterruptedException {

        NioEventLoopGroup loopGroup = new NioEventLoopGroup(4);

        try {
            Bootstrap bootstrap = new Bootstrap();

            bootstrap.group(loopGroup).channel(NioSocketChannel.class).handler(new ClientBoundInitializer());


            ChannelFuture sync = bootstrap.connect("127.0.0.1", 8877).sync();

            sync.channel().closeFuture().sync();
        } finally {
            loopGroup.shutdownGracefully();
        }

    }
}
