package netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.HashMap;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/11 19:35
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 数据读取
     *
     * @param ctx handler上下文
     * @param msg 数据
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        //由netty提供的ByteBuf
        ByteBuf buf = (ByteBuf) msg;

        System.out.println("收到客户端回复消息：" + buf.toString(CharsetUtil.UTF_8));
        System.out.println("当前线程：" + Thread.currentThread().getName());

    }

    /**
     * 数据读取完毕处理
     *
     * @param ctx handler上下文
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {

        //将数据携带缓冲
        ctx.writeAndFlush(Unpooled.copiedBuffer("Hello,Client", CharsetUtil.UTF_8));
    }

    /**
     * 出现异常关闭管道
     *
     * @param ctx   handler上下文
     * @param cause 异常
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}
