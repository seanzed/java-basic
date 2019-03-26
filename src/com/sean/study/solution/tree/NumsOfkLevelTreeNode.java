package com.sean.study.solution.tree;

/**
 * @Description: 求二叉树第k层节点数量
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-19 12:35
 * @Version: 1.0
 */
public class NumsOfkLevelTreeNode {

    public int numsOfLevelTreeNode (TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }

        int left = numsOfLevelTreeNode(root.left, k -1);
        int right = numsOfLevelTreeNode(root.right, k -1);
        return left + right;
    }
}
