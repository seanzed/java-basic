package com.sean.study.solution.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 二叉树后续遍历
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-22 15:28
 * @Version: 1.0
 */
public class PostOrder {

    /**
     * 二叉树后续递归方式遍历
     * @param root
     * @return
     */
    public static List<Integer> postOrderRescursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    public static void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }
}
