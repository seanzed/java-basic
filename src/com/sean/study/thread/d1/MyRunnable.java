package com.sean.study.thread.d1;

/**
 * @Description: 通过实现Runnable接口创建线程
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-02-26 10:22
 * @Version: 1.0
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("My Runnable");
    }
}
