package com.sean.study.solution.datastructure.linkedlist;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，
 * 则在该链表中没有环。
 *
 * 示例 1：
 *      输入：head = [3,2,0,-4], pos = 1
 *      输出：true
 *      解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 *      输入：head = [1,2], pos = 0
 *      输出：true
 *      解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * @Description: 环形链表
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-26 16:06
 * @Version: 1.0
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) return head;

        ListNode fast = head;
        ListNode slow = head;

        return null;
    }
}
