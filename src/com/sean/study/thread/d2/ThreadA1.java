package com.sean.study.thread.d2;

/**
 * @Description: TODO
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-02-26 11:46
 * @Version: 1.0
 */
public class ThreadA1 extends Thread {

    private PublicVar publicVar;

    public ThreadA1(PublicVar publicVar) {
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        publicVar.setValue("B", "BB");
    }
}
