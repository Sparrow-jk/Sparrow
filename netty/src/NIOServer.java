import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/7 0:38
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {
        //创建serverSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //创建selector对象
        Selector selector = Selector.open();

        //绑定端口
        serverSocketChannel.bind(new InetSocketAddress(6666));

        //设置非阻塞
        serverSocketChannel.configureBlocking(false);

        //把serverSocketChannel注册到selector

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //循环等待客户端
        while (true) {

            //获取事件个数
            if (selector.select(3000) == 0) {
                System.out.println("等待客户端连接...");
                continue;
            }
            //获取事件
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            //遍历selectionKey
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                // 处理连接事件
                if (key.isAcceptable()) {
                    System.out.println("客户端连接成功。");

                    //获得socketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();

                    //非阻塞
                    socketChannel.configureBlocking(false);

                    //注册socketChannel
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                //处理读事件
                if (key.isReadable()) {
                    //反向获得socketChanel
                    SocketChannel channel = (SocketChannel) key.channel();
                    //获取buffer
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    //读到服务段
                    channel.read(buffer);
                    System.out.println("from 客户端 " + new String(buffer.array()));

                }

                keyIterator.remove();

            }


        }
    }

}
