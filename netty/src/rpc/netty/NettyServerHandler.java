package rpc.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import rpc.consumer.ClientBootstrap;
import rpc.provider.HelloServiceImpl;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/23 16:21
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("收到客户端消息：" + msg);
        //定义协议 例 消息开头以某个字符串开头 ”HelloService#hello#你好“

        if (msg.toString().startsWith(ClientBootstrap.providerName)) {
            String result = new HelloServiceImpl().hello(msg.toString().substring(msg.toString().lastIndexOf("#") + 1));
            ctx.writeAndFlush(result);
        }


    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
