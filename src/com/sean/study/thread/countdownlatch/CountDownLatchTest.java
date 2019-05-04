package com.sean.study.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * description
 * CountDownLatch类位于java.util.concurrent包下，利用它可以实现类似计数器的功能。比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了。
 * @author chenxu 2019/05/04 23:56
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("子线程： " + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(3000);
                    System.out.println("子进程： " + Thread.currentThread().getName() + "执行完毕");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("子线程： " + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(3000);
                    System.out.println("子进程： " + Thread.currentThread().getName() + "执行完毕");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();

        try {
            System.out.println("等待两个子进程执行完成。。。");
            countDownLatch.await();
            System.out.println("2个子进程已经执行完成");
            System.out.println("继续执行主进程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
