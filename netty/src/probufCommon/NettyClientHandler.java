package probufCommon;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.Random;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/11 20:03
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    /**
     * 通道就绪事件
     *
     * @param ctx handler上下文
     * @throws Exception 异常
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int i = new Random().nextInt(3);
        MyDataInfo.MyMessage myMessage;

        if (i == 0) {
            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.StudentType)
                    .setStudent(MyDataInfo.Student.newBuilder().setId(1).setName("aa").build()).build();

        }else {
            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.WorkerType)
                    .setWorker(MyDataInfo.Worker.newBuilder().setAge(22).setName("bb").build()).build();
        }

        ctx.writeAndFlush(myMessage);
    }

    /**
     * 通道读入事件
     *
     * @param ctx handler上下文
     * @param msg 消息
     * @throws Exception 异常
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf buf = (ByteBuf) msg;
        System.out.println("收到服务器回复消息：" + buf.toString(CharsetUtil.UTF_8));
    }

    /**
     * 出现异常关闭管道
     *
     * @param ctx   handler上下文
     * @param cause 异常
     * @throws Exception 异常
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
