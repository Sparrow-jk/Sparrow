package tcp;

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
public class ServerHandler extends SimpleChannelInboundHandler<ByteBuf> {
    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        byte[] bytes = new byte[msg.readableBytes()];
        msg.readBytes(bytes);

        String message = new String(bytes, CharsetUtil.UTF_8);

        System.out.println("服务器接收数据 " + message);
        System.out.println("接收数据量 " + (++this.count));

        ByteBuf response = Unpooled.copiedBuffer(UUID.randomUUID().toString(), CharsetUtil.UTF_8);

        ctx.writeAndFlush(response);
    }
}
