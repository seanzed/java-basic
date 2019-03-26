package com.sean.study.thread.d2;

/**
 * @Description: synchronized线程安全测试
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-02-26 11:21
 * @Version: 1.0
 */
public class HasSelfPrivateNum {

    private int num = 0;

    public synchronized void addN(String name) {
        try {
            if ("a".equals(name)) {
                num = 100;
                System.out.println("a set over");
                Thread.sleep(1000);
            } else {
                num = 200;
                System.out.println("b set over");
            }

            System.out.println(name + " num = " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
