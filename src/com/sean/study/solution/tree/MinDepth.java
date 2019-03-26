package com.sean.study.solution.tree;

/**
 * @Description: 查询最小树
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-19 11:55
 * @Version: 1.0
 */
public class MinDepth {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null || root.right == null) {
            return 1;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

}
