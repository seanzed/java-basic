package com.sean.study.solution.junior.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *  示例 1:
 *      输入: "abcabcbb"
 *      输出: 3
 *      解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *  示例 2:
 *      输入: "bbbbb"
 *      输出: 1
 *      解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *  示例 3:
 *      输入: "pwwkew"
 *      输出: 3
 *      解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @Description: 无重复长度子串
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-02-28 16:45
 * @Version: 1.0
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = " ";
        int i = method1(s);
        System.out.println(i);
    }

    public static int method1(String s) {

        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (allUnique(s, i, j)) {
                    maxLength = Math.max(maxLength, j - i);
                }
            }
        }

        return maxLength;
    }

    public static boolean allUnique(String s, int start, int end) {

        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = start; i < end; i++) {
            if(set.contains(chars[i])) {
                return false;
            }

            set.add(chars[i]);
        }
        return true;
    }
}
