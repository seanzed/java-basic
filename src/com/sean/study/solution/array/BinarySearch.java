package com.sean.study.solution.array;

/**
 * @Description: 二分法查找
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-18 20:59
 * @Version: 1.0
 */
public class BinarySearch {

    public static int searchIndex(int key, int[] arr) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        int start = 0, end = arr.length;
        if ( key < arr[start] || key > arr[end]) {
            return -1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key > arr[mid]) {
                start = mid + 1;
            } else if (key < arr[mid]) {
                end = mid - 1;
            } else {

                while (mid - 1 >= 0 && arr[mid -1] == key ) {
                    mid--;
                }
                return mid;
            }
        }
        return -1;
    }

}
