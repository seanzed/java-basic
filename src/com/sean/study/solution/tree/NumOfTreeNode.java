package com.sean.study.solution.tree;

/**
 *
 * @Description: 二叉树节点个数
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-19 11:59
 * @Version: 1.0
 */
public class NumOfTreeNode {

    public int numOfTreeNode(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return numOfTreeNode(root.left) + numOfTreeNode(root.right) + 1;
    }
}
