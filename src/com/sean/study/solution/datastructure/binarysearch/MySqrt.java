package com.sean.study.solution.datastructure.binarysearch;

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *      输入: 4
 *      输出: 2
 *
 * 示例 2:
 *      输入: 8
 *      输出: 2
 *      说明: 8 的平方根是 2.82842...,
 *           由于返回类型是整数，小数部分将被舍去。
 *
 * @Description: x 的平方根
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-04-02 22:07
 * @Version: 1.0
 */
public class MySqrt {

    /**
     * 会超出时间范围
     * @param x
     * @return
     */
    public int mySqrt1(int x) {
        int left = 1;
        int right = x;
        int mid = (left + right) / 2;

        while ((right - left) > 1) {

            if (mid == x / mid) {
                return mid;

            }

            if (mid > x / mid) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return mid;
    }
}
