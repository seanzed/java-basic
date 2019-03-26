package com.sean.study.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 1. 从FileInputStream获取Channel
 * 2. 创建Buffer
 * 3. 将数据从Channel写入到Buffer中
 * @Description: 文件管道测试
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-20 17:05
 * @Version: 1.0
 */
public class FileChannelWriteTest {

    private static byte[] message = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static void main(String[] args) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\test.txt");

        // 获取管道
        FileChannel channel = fileOutputStream.getChannel();

        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        for (int i = 0; i < message.length; i++) {
            buffer.put(message[i]);
        }
        buffer.flip();

        // 将缓冲区数据写到管道中
        channel.write(buffer);

        channel.close();
    }
}
