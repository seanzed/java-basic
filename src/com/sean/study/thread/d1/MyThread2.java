package com.sean.study.thread.d1;

/**
 * @Description: 测试线程变量是否安全
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-02-26 10:34
 * @Version: 1.0
 */
public class MyThread2 extends Thread {

    private int count = 100;

    public MyThread2() {
    }

    @Override
    public synchronized void run() {
        while(count > 0) {
            count--;
            System.out.println("由" + MyThread2.currentThread().getName() + "计算得出， count = " + count);
        }

    }
}
