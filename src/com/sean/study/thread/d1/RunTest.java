package com.sean.study.thread.d1;

/**
 * @Description: 线程测试类
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-02-26 10:25
 * @Version: 1.0
 */
public class RunTest {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("调用线程结束");

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        System.out.println("调用线程结束");
    }
}
