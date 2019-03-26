package com.sean.study.solution.dybamicplanning;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 相当于斐波那契函数
 * @Description: 爬楼梯
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-25 15:23
 * @Version: 1.0
 */
public class ClimbStairs {

    /**
     * 递归版实现， 但是会导致超时
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return climbStairs(n -1) + climbStairs(n - 2);
    }

    /**
     * 非递归实现
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int[] ans = new int[n];
            ans[0] = 1;
            ans[1] = 2;
            for (int i = 2; i < n; i++) {
                ans[n] = ans[n-1] + ans[n-2];
            }

            return ans[n-1];
        }
    }
}
