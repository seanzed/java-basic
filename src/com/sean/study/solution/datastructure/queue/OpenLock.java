package com.sean.study.solution.datastructure.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *
 *
 *
 * 示例 1:
 *      输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 *      输出：6
 *      解释：
 *          可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 *          注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 *          因为当拨动到 "0102" 时这个锁就会被锁定。
 *
 * 示例 2:
 *      输入: deadends = ["8888"], target = "0009"
 *      输出：1
 *      解释：
 *          把最后一位反向旋转一次即可 "0000" -> "0009"。
 *
 * 示例 3:
 *      输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 *      输出：-1
 *      解释：
 *          无法旋转到目标数字且不被锁定。
 *
 * 示例 4:
 *      输入: deadends = ["0000"], target = "8888"
 *      输出：-1
 *
 *
 * 提示：
 *      死亡列表 deadends 的长度范围为 [1, 500]。
 *      目标数字 target 不会在 deadends 之中。
 *      每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
 *
 * @Description: 打开转盘锁
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-04-02 19:58
 * @Version: 1.0
 */
public class OpenLock {

    public int openLock(String[] deadends, String target) {

        //0~9999共10000种可能
        boolean[] isVisit = new boolean[10000];
        boolean[] isDead = new boolean[10000];
        for (String deadEnd : deadends) {
            //字符串转十进制数，“0101”=101；
            int deadNum = Integer.parseInt(deadEnd);
            //标记deadends里的数字是禁忌数
            isDead[deadNum] = true;
        }
        //如果"0000"在deadEnds中，返回-1
        if (isDead[0]) {
            return -1;
        }
        if ("0000".equals(target)) {
            return 0;
        }

        int step = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        //放入target作为根节点，查找到“0000”退出
        queue.offer(Integer.parseInt(target));
        //标记target已经访问
        isVisit[Integer.parseInt(target)] = true;
        //当前最后一个数
        int last = Integer.parseInt(target);
        int cenglast = last;
        while (!queue.isEmpty()) {
            while (true) {
                int[] neighbor = new int[8];
                int head = queue.poll();
                if (head == 0) {
                    //查找到“0000”退出
                    return step;
                }
                //邻居节点
                int[] nei = neighbor(head);
                for (int i = 0; i < 8; i++) {
                    int trans = nei[i];
                    if (isVisit[trans] || isDead[trans]) {
                        //如果邻居节点已经访问或者是禁忌数，则跳过下面的步骤，直接i++
                        continue;
                    }
                    //如果不是将这个数放入队列
                    queue.offer(trans);
                    last = trans;
                    //标记为已尝试
                    isVisit[trans] = true;
                }
                if (head == cenglast) {
                    //如果当前的节点和上一层的最后一个节点相同，说明已经遍历了这一整层
                    //退出第二层while循环
                    break;
                }
            }
            step++;
            cenglast = last;
        }
        return -1;
    }

    /**
     * 转成int型之后用 +9，+1来取余数，+9相当于-1，还避免了用if来求解。
     */
    private int[] neighbor(int code) {
        int[] res = new int[8];
        int a = code % 10;
        int b = (code / 10) % 10;
        int c = (code / 100) % 10;
        int d = (code / 1000) % 10;
        res[0] = d * 1000 + c * 100 + b * 10 + (a + 10 - 1) % 10;
        res[1] = d * 1000 + c * 100 + b * 10 + (a + 1) % 10;
        res[2] = d * 1000 + c * 100 + ((b + 10 - 1) % 10) * 10 + a;
        res[3] = d * 1000 + c * 100 + ((b + 1) % 10) * 10 + a;
        res[4] = d * 1000 + ((c + 10 - 1) % 10) * 100 + b * 10 + a;
        res[5] = d * 1000 + ((c + 1) % 10) * 100 + b * 10 + a;
        res[6] = ((d + 10 - 1) % 10) * 1000 + c * 100 + b * 10 + a;
        res[7] = ((d + 1) % 10) * 1000 + c * 100 + b * 10 + a;
        return res;
    }
}
