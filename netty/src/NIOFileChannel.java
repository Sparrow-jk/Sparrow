import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/1 1:10
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class NIOFileChannel {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\vitamin\\Desktop\\fy5.txt");
        FileChannel inputStreamChannel = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\vitamin\\Desktop\\fy5Copy.txt");
        FileChannel outputStreamChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (true) {
            byteBuffer.clear();
            int read = inputStreamChannel.read(byteBuffer);
            if (read == -1) {
                break;
            }
            byteBuffer.flip();
            outputStreamChannel.write(byteBuffer);
        }
        fileInputStream.close();
        fileOutputStream.close();

    }
}
