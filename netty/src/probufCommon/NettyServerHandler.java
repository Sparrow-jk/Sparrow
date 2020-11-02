package probufCommon;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

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
public class NettyServerHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {

    /**
     * 数据读取
     *
     * @param ctx handler上下文
     * @param msg 数据
     * @throws Exception 异常
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {
        MyDataInfo.MyMessage.DataType dataType = msg.getDataType();

        if (dataType == MyDataInfo.MyMessage.DataType.StudentType) {
            MyDataInfo.Student student = msg.getStudent();
            System.out.println("id = " + student.getId() + " ,name = " + student.getName());
        } else if (dataType == MyDataInfo.MyMessage.DataType.WorkerType) {
            MyDataInfo.Worker worker = msg.getWorker();
            System.out.println("age = " + worker.getAge() + " ,name = " + worker.getName());
        } else {
            System.out.println("dataType wrong");
        }
    }

    /**
     * 数据读取完毕处理
     *
     * @param ctx handler上下文
     * @throws Exception 异常
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        //将数据携带缓冲
        ctx.writeAndFlush(Unpooled.copiedBuffer("Hello,Client", CharsetUtil.UTF_8));
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
