package com.sean.study.solution.datastructure.queue;

/**
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 *
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 *
 * 你的实现应该支持如下操作：
 *
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 *
 * @Description: 循环队列设计
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-25 16:23
 * @Version: 1.0
 */
public class MyCircularQueue {

    private int[] data;
    private int head;
    private int tail;
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) throws Exception {
        if (k < 1) {
            throw new Exception("队列长度小于1");
        }
        data = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        // 如果队列满了， 返回false
        if (isFull()) {
            return false;
        }

        if (isEmpty()) {
            head = 0;
        }

        tail = (tail + 1) % size;
        data[tail] = value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (tail == head) {
            tail = -1;
            head = -1;
            return true;
        }
        head = head + 1 % size;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return tail == -1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (tail + 1) % size == head;
    }

    public static void main(String[] args) throws Exception {
        // 设置长度为 3
        MyCircularQueue circularQueue = new MyCircularQueue(3);

        // 返回 true
        System.out.println(circularQueue.enQueue(1));

        // 返回 true
        System.out.println(circularQueue.enQueue(2));

        // 返回 true
        System.out.println(circularQueue.enQueue(3));

        // 返回 false，队列已满
        System.out.println(circularQueue.enQueue(4));

        // 返回 3
        System.out.println(circularQueue.Rear());

        // 返回 true
        System.out.println(circularQueue.isFull());

        // 返回 true
        System.out.println(circularQueue.deQueue());

        // 返回 true
        System.out.println(circularQueue.enQueue(4));

        // 返回 4
        System.out.println(circularQueue.Rear());
    }
}
