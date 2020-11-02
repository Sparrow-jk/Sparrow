package protocaltcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/18 0:27
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class MessageDecoder extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("message 被调用");
        int length = in.readInt();
        byte[] content = new byte[length];

        in.readBytes(content);

        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLenth(length);
        messageProtocol.setContent(content);
        
        out.add(messageProtocol);
    }
}
