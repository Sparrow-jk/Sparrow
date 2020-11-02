package protocaltcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/17 23:50
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class ClientHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    private int count;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 5; i++) {
            String msg = "hello protocolTCP";
            byte[] content = msg.getBytes(CharsetUtil.UTF_8);
            int length = content.length;

            //协议对象
            MessageProtocol messageProtocol = new MessageProtocol();
            messageProtocol.setContent(content);
            messageProtocol.setLenth(length);
            ctx.writeAndFlush(messageProtocol);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        byte[] content = msg.getContent();
        int length = content.length;

        String message = new String(content, CharsetUtil.UTF_8);
        System.out.println("客户端接收数据 " + message);
        System.out.println("客户端接收数据长度 " + length);
        System.out.println("接收数据量 " + (++this.count));


    }
}
