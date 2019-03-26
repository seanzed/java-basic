package com.sean.study.thread.d1;

/**
 * @Description: 测试线程方法
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-02-26 10:51
 * @Version: 1.0
 */
public class MyThread3 extends Thread {

    @Override
    public void run() {
        Thread thread = MyThread3.currentThread();
        System.out.println("获取当前线程的引用：" + thread);
        String name = thread.getName();
        System.out.println("获取当前线程名：" + name);
        long id = thread.getId();
        System.out.println("获取当前线程标识符：" + id);
        int priority = thread.getPriority();
        System.out.println("获取当前线程的优先级：" + priority);
        boolean alive = thread.isAlive();
        System.out.println("测试当前线程是否还存活：" + alive);
        boolean daemon = thread.isDaemon();
        System.out.println("获取当前线程是否为守护线程：" + daemon);
    }
}
