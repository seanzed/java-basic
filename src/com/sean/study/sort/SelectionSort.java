package com.sean.study.sort;

/**
 * 简介：选择排序(Selection-sort)是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，
 * 存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕。
 *
 * 适用场景：表现最稳定的排序算法之一(这个稳定不是指算法层面上的稳定哈，相信聪明的你能明白我说的意思2333)，
 * 因为无论什么数据进去都是O(n²)的时间复杂度.....所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外
 * 的内存空间了吧。理论上讲，选择排序可能也是平时排序一般人想到的最多的排序方法了吧。
 *
 * 最佳情况：T(n) = O(n^n)  最差情况：T(n) = O(n^2)  平均情况：T(n) = O(n^2)
 * @Description: 选择排序
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-02-18 15:30
 * @Version: 1.0
 */
public class SelectionSort {

    public static int[] selectionSort(int[] array) {
        if (array.length == 0 || array.length == 1) return array;
        long startTime = System.currentTimeMillis();
        int len = array.length;
        int minIndex, temp;

        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                //寻找最小的数
                if (array[j] < array[minIndex]) {
                    //将最小数的索引保存
                    minIndex = j;
                }
            }
            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("排序耗时：" + (endTime - startTime));
        return array;
    }
}
