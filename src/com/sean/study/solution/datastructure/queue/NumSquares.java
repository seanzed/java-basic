package com.sean.study.solution.datastructure.queue;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 * 四平方和定理说明：每个正整数，均可表示为4个整数的平方和。因此结果只有1,2,3,4，四种可能。满足四数平方和定理的数n（这里要满足由四个数构成，小于四个不行），必定满足
 * n=4^a * (8 * b + 7)
 *
 * @Description: 完全平方数
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-04-02 20:17
 * @Version: 1.0
 */
public class NumSquares {


    /**
     * Lagrange 四平方定理： 任何一个正整数都可以表示成不超过四个整数的平方之和。
     * 结果只有1,2,3,4，四种可能。
     * 推论：满足四数平方和定理的数n（必须满足由四个数构成），必定满足 n=4^a*(8b+7)
     * @param n
     * @return
     */
    public int numSquares(int n) {
        while (n % 4 == 0) {
            n /= 4;
        }
        // 满足推论 说明由4个完全平方数构成
        if (n % 8 == 7) return 4;
        int a = 0;
        while (a * a <= n) {
            // 判断这个缩小后的数是否可以通过两个平方数的和或一个平方数组成
            // 如果n=a^2 那么b=0
            int b = (int) (Math.sqrt((n - a * a)));
            // if (a * a == n)
            // return 1;
            //返回 a、b中非0的个数和
            if (a * a + b * b == n) return (a != 0 ? 1 : 0) + (b != 0 ? 1 : 0);
            a += 1;
        }
        return 3;
    }
}
