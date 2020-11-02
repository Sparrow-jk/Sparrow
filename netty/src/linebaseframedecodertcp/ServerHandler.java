package linebaseframedecodertcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import protocaltcp.MessageProtocol;

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




        String response = "response" + message + System.getProperty("line.separator");
        ByteBuf resp = Unpooled.copiedBuffer(response.getBytes());

        ctx.writeAndFlush(resp);

    }
}
