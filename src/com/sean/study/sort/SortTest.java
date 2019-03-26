package com.sean.study.sort;

/**
 * @Description: 排序测试
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-11 19:31
 * @Version: 1.0
 */
public class SortTest {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

        int[] sortArr = ShellSort.shellSort(arr);
        printArr(sortArr);

    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
