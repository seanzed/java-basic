package com.sean.study.sort;

/**
 * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
 * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会
 * 经由交换慢慢“浮”到数列的顶端。
 *
 * 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
 * @Description: 冒泡排序算法
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-02-18 15:16
 * @Version: 1.0
 */
public class BubbleSort {

    public static int [] bubbleSort(int[] array) {
        if (array.length == 0) return array;

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("排序耗时：" + (endTime - startTime));
        return array;
    }

    public static int[] bubbleSort2(int[] array) {
        long startTime = System.currentTimeMillis();
        //初始时,最后位置保持不变
        int i = array.length - 1;
        while ( i > 0) {
            //每趟开始时,无记录交换
            int pos= 0;
            for (int j= 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    //记录交换的位置
                    pos = j;
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
                //为下一趟排序作准备
                i = pos;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("排序耗时：" + (endTime - startTime));
        return array;
    }

}
