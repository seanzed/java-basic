package com.sean.study.solution.datastructure.linkedlist;

/**
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，
 * next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中
 * 的所有节点都是 0-index 的。
 *
 * 在链表类中实现这些功能：
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，
 * 则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 *
 * 示例：
 *
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 *
 *
 * 提示：
 *
 * 所有值都在 [1, 1000] 之内。
 * 操作次数将在  [1, 1000] 之内。
 * 请不要使用内置的 LinkedList 库。
 *
 * @Description: 设计链表
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-26 11:44
 * @Version: 1.0
 */
public class MyLinkedList {

    private ListNode head;

    private int size;

    /**
     * 在构造函数初始化数据
     */
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * 获取链表中第 index 个节点的值。如果索引无效，则返回-1。
     * @param index
     * @return
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode current = head;
        while (index-- > 0) {
            current = current.next;
        }
        return current.val;
    }

    /**
     * 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
     * @param val
     */
    public void addAtHead(int val) {
        size++;
        ListNode newHead = new ListNode(val);
        if (head != null) {
            newHead.next = head;
        }
        this.head = newHead;

    }

    /**
     * 将值为 val 的节点追加到链表的最后一个元素。
     * @param val
     */
    public void addAtTail(int val) {
        size++;
        ListNode newTail = new ListNode(val);
        if (head == null) {
            head = newTail;
            return;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTail;

        }
    }

    /**
     * 在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。
     * 如果 index 大于链表长度，则不会插入节点。
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        // 如果链表还没有元素， 加入到头中
        if (index == 0) {
            addAtHead(val);
        } else {
            ListNode current = head;
            while (--index > 0) {
                current = current.next;
            }
            ListNode newNode = new ListNode(val);
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }

    }

    /**
     * 如果索引 index 有效，则删除链表中的第 index 个节点。
     * @param index
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        ListNode prev = head;
        while (--index > 0) {
            prev = prev.next;
        }
        ListNode delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;

    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        System.out.println(linkedList.get(0));

        linkedList.addAtTail(3);
        System.out.println(linkedList.get(1));
        //链表变为1-> 2-> 3
        linkedList.addAtIndex(1,2);
        //返回2
        int i = linkedList.get(1);
        System.out.println(i);
        //现在链表是1-> 3
        linkedList.deleteAtIndex(1);
        //返回3
        int ii = linkedList.get(1);
        System.out.println(ii);

    }
}

