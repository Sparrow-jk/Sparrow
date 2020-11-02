package protocaltcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/18 0:24
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class MessageEncoder extends MessageToByteEncoder<MessageProtocol> {
    @Override
    protected void encode(ChannelHandlerContext ctx, MessageProtocol msg, ByteBuf out) throws Exception {
        System.out.println("MessageEncoder被调用");
        out.writeInt(msg.getLenth());
        out.writeBytes(msg.getContent());
    }
}
