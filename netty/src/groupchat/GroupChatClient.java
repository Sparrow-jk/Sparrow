package groupchat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/15 0:15
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class GroupChatClient {


    private final String host;

    private final int port;

    public GroupChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void init() throws InterruptedException {

        NioEventLoopGroup loopGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(loopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {

                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new StringDecoder());
                            pipeline.addLast(new StringEncoder());
                            pipeline.addLast(new GroupChatClientHandler());

                        }
                    });

            ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
            Channel channel = channelFuture.channel();
            System.out.println("-----------------------" + channel.localAddress() + "--------------------------");

            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                channel.writeAndFlush(s + "\r\n");

            }


        } finally {
            loopGroup.shutdownGracefully();
        }


    }

    public static void main(String[] args) throws InterruptedException {
        new GroupChatClient("127.0.0.1", 8899).init();
    }


}
