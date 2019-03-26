package com.sean.study.solution.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 二叉树中序遍历
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-22 15:28
 * @Version: 1.0
 */
public class InOrder {

    /**
     * 非递归中序遍历
     * @param root 根节点
     * @return
     */
    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                list.add(current.val);
                current = current.right;
            }
        }
        return list;
    }

    /**
     * 二叉树中序递归方式遍历
     * @param root
     * @return
     */
    public static List<Integer> inOrderRescursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    public static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
