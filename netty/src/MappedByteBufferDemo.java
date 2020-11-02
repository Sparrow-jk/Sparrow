import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/1 12:49
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class MappedByteBufferDemo {
    public static void main(String[] args) throws IOException {


        RandomAccessFile accessFile = new RandomAccessFile("C:\\Users\\vitamin\\Desktop\\fy5Copy.txt", "rw");
        FileChannel channel = accessFile.getChannel();
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 100);
        mappedByteBuffer.put(0,"J".getBytes()[0]);
        accessFile.close();
    }

}
