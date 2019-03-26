package com.sean.study.solution.tree;

/**
 * @Description: 求二叉树中叶子节点的个数
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-19 12:33
 * @Version: 1.0
 */
public class NumsOfNoChildNode {

    public int numsOfNoChildNode(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return numsOfNoChildNode(root.left) + numsOfNoChildNode(root.right);
    }
}
