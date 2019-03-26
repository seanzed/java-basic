package com.sean.study.solution.junior.array;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 示例 2:
 *      给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 *      函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * @Description: 移除数组重复项， 返回新数组长度
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-02-28 14:16
 * @Version: 1.0
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int method = method(nums);
        System.out.println(method);
    }

    public static int method(int[] nums) {
        int[] newNums = nums;
        for (int i = 0; i < newNums.length; i++) {
            for (int j = i + 1; i < newNums.length; j++ ) {
                if (newNums[i] == newNums[j]) {

                }
            }
        }

        return 1;
    }
}
