package protocaltcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.util.UUID;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/17 23:52
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class ServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {
    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        byte[] content = msg.getContent();
        int lenth = msg.getLenth();

        String message = new String(content, CharsetUtil.UTF_8);

        System.out.println("服务器接收数据 " + message);
        System.out.println("服务器接收数据长度 " + lenth);
        System.out.println("接收数据量 " + (++this.count));


        byte[] bytes = UUID.randomUUID().toString().getBytes(CharsetUtil.UTF_8);
        int length = bytes.length;

        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setContent(bytes);
        messageProtocol.setLenth(length);
        ctx.writeAndFlush(messageProtocol);

    }
}
