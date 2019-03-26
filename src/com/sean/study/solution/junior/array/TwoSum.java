package com.sean.study.solution.junior.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 *
 *      给定 nums = [2, 7, 11, 15], target = 9
 *      因为 nums[0] + nums[1] = 2 + 7 = 9
 *      所以返回 [0, 1]
 * @Description: 判断两束相加
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-02-28 15:20
 * @Version: 1.0
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 2};
        int target = 5;
//        int[] ints = method1(nums, target);
        int[] ints = method3(nums, target);
        printNum(ints);
    }

    public static int[] method1(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++ ) {
                if (nums[i] == target - nums[j]) {
                    return new int[] {i, j};
                }
            }
        }

        throw new IllegalArgumentException("参数异常");
    }


    public static int[] method2(int[] nums, int target) {

        Map map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i =0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && (Integer)map.get(complement) != i) {
                return new int[] {i, (Integer)map.get(complement)};
            }
        }

        throw new IllegalArgumentException("参数异常");
    }

    public static int[] method3(int[] nums, int target) {

        Map map = new HashMap<Integer, Integer>();

        for (int i =0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {i, (Integer)map.get(complement)};
            }

            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("参数异常");
    }

    public static void printNum(int[] nums) {
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
