package com.sean.study.solution.tree;

/**
 * @Description: 树
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-19 11:49
 * @Version: 1.0
 */
public class TreeNode {

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    int val;

    /**
     * 左子树
     */
    public TreeNode left;

    /**
     * 右子树
     */
    public TreeNode right;
}
