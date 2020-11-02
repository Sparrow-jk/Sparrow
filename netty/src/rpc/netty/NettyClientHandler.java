package rpc.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/23 16:34
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable<String> {


    private ChannelHandlerContext context;
    private String result;
    private String parameter;


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        context = ctx;
    }

    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("读取中");
        result = msg.toString();
        notify();
    }


    @Override
    public synchronized String call() throws Exception {
        context.writeAndFlush(parameter);
        System.out.println("发送call" + parameter);
        wait();
        return result;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.channel().close();
    }


}
