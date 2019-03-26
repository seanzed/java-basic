package com.sean.study.solution.sort;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 *      说明:
 *      初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 *      你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * @Description: TODO
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-18 17:48
 * @Version: 1.0
 */
public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }

        for (int i = 0; i < m + n; i++) {
            for (int j = 0; j < m + n - i - 1; j++) {
                if (nums1[j] > nums1[j+1]) {
                    int temp = nums1[j+1];
                    nums1[j+1]  = nums1[j];
                    nums1[j] = temp;
                }
            }
        }
    }
}
