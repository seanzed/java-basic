package com.sean.study.thread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * description 字面意思回环栅栏，通过它可以实现让一组线程等待至某个状态之后再全部同时执行。叫做回环是因为当所有等待线程都被释放以后，CyclicBarrier可以被重用。
 * 我们暂且把这个状态就叫做barrier，当调用await()方法之后，线程就处于barrier了。
 *
 * @author chenxu 2019/05/05 00:20
 */
public class CyclicBarrier2Test {

    public static void main(String[] args) {
        
        int n = 4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
        for (int i = 0; i < n; i++) {
            if (i < n - 1)
                new Worker(cyclicBarrier).start();
            else {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new Worker(cyclicBarrier).start();
            }
        }
    }

    static class Worker extends Thread {

        private CyclicBarrier cyclicBarrier;

        public Worker(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程：" + Thread.currentThread().getName() + "正在写入");

            try {
                // 以睡眠模拟数据库操作
                Thread.sleep(3000);
                System.out.println("线程：" + Thread.currentThread().getName() + "写入完成");
                // 让其等待
                cyclicBarrier.await(1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }

            System.out.println("所有线程写入完成继续执行其他任务");
        }
    }
}
