package com.sean.study.solution.array.doublepoint;

/**
 * description
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例:
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 * @author chenxu 2019/05/04 16:30
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = -1, sum = 0, res = nums.length + 1;
        while (l < nums.length) {
            if (sum < s && r+1 < nums.length) {
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }

            if (sum >= s) {
                res = Math.min(res, r - l + 1);
            }
        }

        if (res == nums.length + 1) return 0;

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,3,1,2,4,3};
        int s= 7;

    }
}
