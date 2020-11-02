package linebaseframedecodertcp;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import protocaltcp.MessageDecoder;


/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/17 23:49
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //pipeline.addLast(new LineBasedFrameDecoder(1024));
        pipeline.addLast(new MessageDecoder());
        pipeline.addLast(new StringEncoder());
        pipeline.addLast(new ServerHandler());
    }
}
