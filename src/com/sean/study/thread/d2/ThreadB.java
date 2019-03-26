package com.sean.study.thread.d2;

/**
 * @Description: 线程A
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-02-26 11:28
 * @Version: 1.0
 */
public class ThreadB extends Thread {

    private HasSelfPrivateNum hasSelfPrivateNum;

    public ThreadB(HasSelfPrivateNum hasSelfPrivateNum) {
        this.hasSelfPrivateNum = hasSelfPrivateNum;
    }

    @Override
    public void run() {
        hasSelfPrivateNum.addN("b");
    }
}
