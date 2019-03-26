package com.sean.study.thread.d2;

/**
 * @Description: 测试线程锁脏读
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-02-26 11:40
 * @Version: 1.0
 */
public class PublicVar {

    public String username = "A";
    public String password = "AA";

    public synchronized void setValue(String username, String password) {

        try {
            this.username = username;
            Thread.sleep(1000);

            this.password = password;

            System.out.println("setValue method thread name" + Thread.currentThread().getName() +
                " username = " + username + ", password = " + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getValue() {
        System.out.println("getValue method thread name" + Thread.currentThread().getName() +
            " username = " + username + ", password = " + password);
    }
}
