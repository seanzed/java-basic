package com.sean.study.solution.datastructure.linkedlist;

/**
 * 单链表中的每个结点不仅包含值，还包含链接到下一个结点的引用字段。通过这种方式，单链表将所有结点按顺序组织起来。
 *
 * 与数组不同，我们无法在常量时间内访问单链表中的随机元素。 如果我们想要获得第 i 个元素，我们必须从头结点逐个遍历。
 * 我们按索引来访问元素平均要花费 O(N) 时间，其中 N 是链表的长度。
 *      例如，在上面的示例中，头结点是 23。访问第 3 个结点的唯一方法是使用头结点中的“next”字段到达第 2 个结点
 *      （结点 6）; 然后使用结点 6 的“next”字段，我们能够访问第 3 个结点。
 * 你可能想知道为什么链表很有用，尽管它在通过索引访问数据时（与数组相比）具有如此糟糕的性能。
 *
 * @Description: 单链表数据结构
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-26 11:31
 * @Version: 1.0
 */
public class ListNode {


    int val;

    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
