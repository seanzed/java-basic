package com.sean.study.io.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 1. 从FileInputStream获取Channel
 * 2. 创建Buffer
 * 3. 将数据从Channel读取到Buffer中
 * @Description: 文件管道测试
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-20 17:05
 * @Version: 1.0
 */
public class FileChannelReadTest {

    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("D:\\ioc.xml");

        // 获取管道
        FileChannel channel = fileInputStream.getChannel();

        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 通过管道读取数据到缓冲区
        channel.read(buffer);

        buffer.flip();

        while (buffer.remaining()>0) {
            byte b = buffer.get();
            System.out.print(((char)b));
        }

        channel.close();
    }
}
