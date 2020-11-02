import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/1 12:48
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class ScatterAndGather {

    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);
        serverSocketChannel.socket().bind(inetSocketAddress);
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);
        SocketChannel accept = serverSocketChannel.accept();
        int messageLength = 8;
        while (true) {
            int byteRead = 0;
            while (byteRead < messageLength) {
                System.out.println("before read");
                long read = accept.read(byteBuffers);
                byteRead += read;
                System.out.println("byteRead = " + byteRead);
                Arrays.stream(byteBuffers).map(byteBuffer -> "position = " + byteBuffer.position() + " ," +
                        "limit = " + byteBuffer.limit()).forEach(System.out::println);
            }
            Arrays.asList(byteBuffers).forEach(Buffer::flip);
            long byteWrite = 0;
            while (byteWrite < messageLength) {
                System.out.println("before write");
                long write = accept.write(byteBuffers);
                byteWrite += write;
                System.out.println("writing......");

            }
            Arrays.asList(byteBuffers).forEach(Buffer::clear);
            System.out.println("byteRead = " + byteRead + " ,byteWrite = " + byteWrite + " , messageLength = " + messageLength);

        }
    }
}
