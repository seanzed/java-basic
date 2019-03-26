package com.sean.study.io.nio;

import java.nio.IntBuffer;

/**
 * @Description: 测试nio中buffer
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-20 16:58
 * @Version: 1.0
 */
public class IntBufferTest {

    public static void main(String[] args) {
        // 分配新的int缓冲区，参数为缓冲区容量
        // 新缓冲区的当前位置将为零，其界限(限制位置)将为其容量。它将具有一个底层实现数组，其数组偏移量将为零。
        IntBuffer intBuffer = IntBuffer.allocate(8);

        for (int i = 0; i < intBuffer.capacity(); i++) {
            int j = 2*(i+1);
            // 将给定整数写入此缓冲区的当前位置，当前位置递增
            intBuffer.put(j);
        }

        // 重设此缓冲区，将限制设置为当前位置，然后将当前位置设置为0
        intBuffer.flip();

        // 查看在当前位置和限制位置之间是否有元素
        while (intBuffer.hasRemaining()) {
            int i = intBuffer.get();
            System.out.print(i + " ");
        }

    }
}
