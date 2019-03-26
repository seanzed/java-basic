package com.sean.study.io.nio;

import java.io.FileInputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 在缓冲区中，最重要的属性有下面三个，它们一起合作完成对缓冲区内部状态的变化跟踪：
 *
 * position：指定了下一个将要被写入或者读取的元素索引，它的值由get()/put()方法自动更新，在新创建一个Buffer对象时，
 *           position被初始化为0。
 *
 * limit：指定还有多少数据需要取出(在从缓冲区写入通道时)，或者还有多少空间可以放入数据(在从通道读入缓冲区时)。
 *
 * capacity：指定了可以存储在缓冲区中的最大数据容量，实际上，它指定了底层数组的大小，或者至少是指定了准许我们使用的底层
 *          数组的容量。
 *
 * 以上四个属性值之间有一些相对大小的关系：0 <= position <= limit <= capacity。如果我们创建一个新的容量大小为10的
 * ByteBuffer对象，在初始化的时候，position设置为0，limit和 capacity被设置为10，在以后使用ByteBuffer对象过程中，
 * capacity的值不会再发生变化，而其它两个个将会随着使用而变化
 *
 * @Description: 文件管道测试
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-20 17:05
 * @Version: 1.0
 */
public class FileChannelRead1Test {

    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("D:\\ioc.xml");

        // 获取管道
        FileChannel channel = fileInputStream.getChannel();

        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);

        output("初始化", buffer);

        channel.read(buffer);
        output("调用read()", buffer);

        buffer.flip();
        output("调用flip()", buffer);

        while (buffer.remaining()>0) {
            byte b = buffer.get();
            System.out.print(((char)b));
        }

        output("调用get()", buffer);

        buffer.clear();
        output("调用clear()", buffer);

        channel.close();
    }

    public static void output(String step, Buffer buffer) {
        System.out.println(step + " : ");
        System.out.print("capacity: " + buffer.capacity() + ", ");
        System.out.print("position: " + buffer.position() + ", ");
        System.out.println("limit: " + buffer.limit());
        System.out.println();
    }
}
