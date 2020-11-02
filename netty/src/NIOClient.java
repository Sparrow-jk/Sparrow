import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/7 1:03
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class NIOClient {
    public static void main(String[] args) throws IOException {

        //获得socketChannel
        SocketChannel socketChannel = SocketChannel.open();

        //非阻塞
        socketChannel.configureBlocking(false);

        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);

        //连接服务器
        if (!socketChannel.connect(inetSocketAddress)) {

            while (!socketChannel.finishConnect()) {
                System.out.println("服务器连接中...");
            }
        }

        ByteBuffer buffer = ByteBuffer.wrap("hello NIO".getBytes());
        //写入
        socketChannel.write(buffer);
        System.in.read();
    }

}

