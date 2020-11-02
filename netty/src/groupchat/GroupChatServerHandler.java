package groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/14 23:53
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {

    //Channel组
    private static final ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);


    /**
     * hanlder连接
     *
     * @param ctx 处理器上下文
     * @throws Exception 异常
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();

        channelGroup.writeAndFlush("客户端" + channel.remoteAddress() + "加入聊天");
        channelGroup.add(channel);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("客户端" + channel.remoteAddress() + "离开了");
        //  channelGroup.remove(channel);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端" + ctx.channel().remoteAddress() + "上线了");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端" + ctx.channel().remoteAddress() + "下线了");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

        Channel channel = ctx.channel();

        channelGroup.forEach(ch -> {
            if (channel != ch) {
                ch.writeAndFlush("客户端" + ctx.channel().remoteAddress() + "发送了消息" + msg + "\n");
            } else {
                ch.writeAndFlush("我发送了消息" + msg + "\n");
            }
        });

    }
}
