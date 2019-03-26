package com.sean.study.solution.datastructure.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 自定义栈
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-25 17:44
 * @Version: 1.0
 */
public class MyStack {

    /**
     * 存储数据
     */
    private List<Integer> data;

    public MyStack() {
        data = new ArrayList<>();
    }
    /**
     * 插入一个元素到栈中
     * @param x
     */
    public void push(int x) {
        data.add(x);
    }
    /**
     * 检查该栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }
    /**
     * 返回栈顶数据
     * @return
     */
    public int top() {
        return data.get(data.size() - 1);
    }
    /** Delete an element from the queue. Return true if the operation is successful. */
    public boolean pop() {
        if (isEmpty()) {
            return false;
        }
        data.remove(data.size() - 1);
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        s.push(3);
        for (int i = 0; i < 4; ++i) {
            if (!s.isEmpty()) {
                System.out.println(s.top());
            }
            System.out.println(s.pop());
        }
    }
}