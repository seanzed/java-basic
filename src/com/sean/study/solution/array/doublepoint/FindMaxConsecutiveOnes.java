package com.sean.study.solution.array.doublepoint;

/**
 * description
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 *
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 * @author sean.chen.dev@gmail.com 2019/05/04 15:54
 */
public class FindMaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int l = 0, r = 0, count = 0, res = -1;
        while (l <= r && r < nums.length) {
            if (nums[r++] == 1) {
                count++;
            } else {
                res = Math.max(res, count);
                l = r;
                count = 0;
            }
        }

        return Math.max(res, count);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 0, 1, 1, 0, 1};
        FindMaxConsecutiveOnes consecutiveOnes = new FindMaxConsecutiveOnes();
        int maxConsecutiveOnes = consecutiveOnes.findMaxConsecutiveOnes(nums);
        System.out.println(maxConsecutiveOnes);

    }
}
