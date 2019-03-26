package com.sean.study.thread.d2;

/**
 * @Description: 线程测试类
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-02-26 11:30
 * @Version: 1.0
 */
public class RunTest {

    public static void main(String[] args) {
//        test();
        test1();
    }

    public static void test() {
        HasSelfPrivateNum hasSelfPrivateNumA = new HasSelfPrivateNum();
        HasSelfPrivateNum hasSelfPrivateNumB = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(hasSelfPrivateNumA);
        ThreadB threadB = new ThreadB(hasSelfPrivateNumB);
        threadA.start();
        threadB.start();
    }

    public static void test1() {
        try {
            PublicVar publicVar = new PublicVar();
            ThreadA1 threadA1 = new ThreadA1(publicVar);
            threadA1.start();
            Thread.sleep(500);
            publicVar.getValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
