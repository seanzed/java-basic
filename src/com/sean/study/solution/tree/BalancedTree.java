package com.sean.study.solution.tree;

/**
 * @Description: 判断是否为平衡二叉树
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-22 14:25
 * @Version: 1.0
 */
public class BalancedTree {

    public boolean isBalanced(TreeNode node) {
        return maxDeath(node) != -1;
    }

    public int maxDeath(TreeNode node) {
        if(node == null){
            return 0;
        }
        int left = maxDeath(node.left);
        int right = maxDeath(node.right);
        if (left == -1|| right == -1|| Math.abs(left-right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
