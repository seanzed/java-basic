package com.sean.study.thread.d1;

/**
 * @Description: 通过集成Thread类创建线程
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-02-26 10:21
 * @Version: 1.0
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread");
    }
}
