package com.sean.study.thread.d1;

/**
 * @Description: 多线程测试
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-02-26 10:38
 * @Version: 1.0
 */
public class RunTest1 {

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    public static void test1() {
        MyThread1 a = new MyThread1("A");
        MyThread1 b = new MyThread1("B");
        MyThread1 c = new MyThread1("C");
        a.start();
        b.start();
        c.start();
    }

    public static void test2() {
        MyThread2 myThread2 = new MyThread2();
        Thread a = new Thread(myThread2, "A");
        Thread b = new Thread(myThread2, "B");
        Thread c = new Thread(myThread2, "C");
        Thread d = new Thread(myThread2, "D");
        Thread e = new Thread(myThread2, "E");
        Thread f = new Thread(myThread2, "F");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
        f.start();
    }
    public static void test3() {
        MyThread3 myThread3 = new MyThread3();
        myThread3.start();
    }
}
