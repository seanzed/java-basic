package com.sean.study.sort;

/**
 * 简介：插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，
 * 在已排序序列中从后向前扫描，找到相应位置并插入。插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序）
 * ，因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
 *
 * 最佳情况：T(n) = O(n)   最坏情况：T(n) = O(n^2)   平均情况：T(n) = O(n^2)
 * @Description: 插入排序
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-02-18 15:43
 * @Version: 1.0
 */
public class InsertionSort {

    public static int[] insertionSort(int[] array) {
        if (array.length == 0 || array.length == 1) return array;

        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i+1];
            int preIndex = i;
            while (preIndex >= 1 && current < array[preIndex]) {
                array[preIndex+1] = array[preIndex];
                preIndex--;
            }
            array[preIndex] = current;
        }

        return array;
    }
}
