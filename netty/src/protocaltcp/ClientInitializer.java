package protocaltcp;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/17 23:48
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class ClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new MessageEncoder());
        pipeline.addLast(new MessageDecoder());
        pipeline.addLast(new ClientHandler());

    }
}
