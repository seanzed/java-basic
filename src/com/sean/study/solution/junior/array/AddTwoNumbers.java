package com.sean.study.solution.junior.array;

import java.util.LinkedList;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @Description: 两数相加
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-02-28 15:43
 * @Version: 1.0
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(0);
        ListNode listNode = method1(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


    public static ListNode method1(ListNode l1, ListNode l2) {
        int mod = 0;
        ListNode newL = new ListNode(0);
        ListNode p = l1, q = l2, curr = newL;

        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;

            int sum = x + y + mod;
            mod = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null)  {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }

        if (mod > 0) {
            curr.next = new ListNode(mod);
        }

        return newL.next;
    }

    static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

}
