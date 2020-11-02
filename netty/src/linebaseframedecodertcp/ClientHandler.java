package linebaseframedecodertcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import protocaltcp.MessageProtocol;

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
public class ClientHandler extends SimpleChannelInboundHandler<String> {

    private int count;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 5; i++) {
            String msg = "hello protocolTCP by lineBaseFrameDecoder";
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
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

        System.out.println("The time server receive order : " + msg + " , the counter is : " + ++count);


    }
}
