package com.sean.study.solution.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 判断该二叉树是否为完全二叉树
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-22 14:48
 * @Version: 1.0
 */
public class CompleteTreeNode {

    public boolean isCompleteTreeNode(TreeNode root) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean result = true;
        boolean hasNoChild = false;

        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            if (hasNoChild) {
                if (current.left != null || current.right != null) {
                    result = false;
                    break;
                }
            } else {
                if (current.left != null && current.right != null) {
                    queue.add(current.left);
                    queue.add(current.right);
                } else if (current.left != null && current.right == null) {
                    queue.add(current.left);
                } else if (current.left == null && current.right != null) {
                    result = false;
                    break;
                } else {
                    hasNoChild = true;
                }
            }
        }

        return result;
    }

}
