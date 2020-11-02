package nettyTest;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/14 23:13
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class HttpServerHandlerTest extends SimpleChannelInboundHandler<HttpObject> {

    /**
     * 读取客户段数据
     *
     * @param ctx 处理器上下文
     * @param msg 消息
     * @throws Exception 异常
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {

        if (msg instanceof HttpRequest) {
            System.out.println("reading...");

            ByteBuf byteBuf = Unpooled.copiedBuffer("hello,client", CharsetUtil.UTF_16);

            FullHttpResponse httpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
                    byteBuf);

            httpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");

            httpResponse.headers().set(HttpHeaderNames.CONTENT_LENGTH, byteBuf.readableBytes());

            ctx.writeAndFlush(httpResponse);


        }


    }
}
