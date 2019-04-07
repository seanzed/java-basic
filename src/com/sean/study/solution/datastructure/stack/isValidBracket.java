package com.sean.study.solution.datastructure.stack;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *      左括号必须用相同类型的右括号闭合。
 *      左括号必须以正确的顺序闭合。
 *      注意空字符串可被认为是有效字符串。
 *
 *      示例 1:
 *              输入: "()"
 *              输出: true
 *      示例 2:
 *              输入: "()[]{}"
 *              输出: true
 *      示例 3:
 *              输入: "(]"
 *              输出: false
 *      示例 4:
 *              输入: "([)]"
 *              输出: false
 *      示例 5:
 *              输入: "{[]}"
 *              输出: true
 *
 * @Description: 有效的括号
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-25 20:18
 * @Version: 1.0
 */
public class isValidBracket {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                Character topChar = stack.pop();
                if (ch == ')' && topChar != '(') {
                    return false;
                } else if (ch == '}' && topChar != '{') {
                    return false;
                } else if (ch == ']' && topChar != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
