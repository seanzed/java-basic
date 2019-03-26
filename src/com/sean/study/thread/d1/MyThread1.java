package com.sean.study.thread.d1;

/**
 * @Description: 测试线程变量是否安全
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-02-26 10:34
 * @Version: 1.0
 */
public class MyThread1 extends Thread {

    private int count = 5;

    public MyThread1(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        while(count > 0) {
            count--;
            System.out.println("由" + MyThread1.currentThread().getName() + "计算得出， count = " + count);
        }

    }
}
