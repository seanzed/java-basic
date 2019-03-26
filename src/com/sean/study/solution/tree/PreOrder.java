package com.sean.study.solution.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 二叉树前序遍历
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-22 15:08
 * @Version: 1.0
 */
public class PreOrder {

    /**
     * 非递归方法前序遍历
     * @return
     * @param root
     */
    public static List<Integer> preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            list.add(treeNode.val);
            // 先将右节点放入栈中
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }

            // 后将做节点放入栈中， 先弹出左节点
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }

        return list;
    }

    /**
     * 递归方法前序遍历
     * @param root
     * @return
     */
    public static List<Integer> preOrderRecursion(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    public static void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    /**
     * 遍历测试
     * 测试数据
     *                      6
     *                  4        8
     *                3   5    7    9
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 6;
        TreeNode leftNode = new TreeNode();
        leftNode.val = 4;
        TreeNode rightNode = new TreeNode();
        rightNode.val = 8;
        root.left = leftNode;
        root.right = rightNode;

        TreeNode leftChildNode = new TreeNode();
        leftChildNode.val = 3;
        TreeNode rightChildNode = new TreeNode();
        rightChildNode.val = 5;
        leftNode.left = leftChildNode;
        leftNode.right = rightChildNode;

        TreeNode leftChildNode1 = new TreeNode();
        leftChildNode1.val = 7;
        TreeNode rightChildNode1 = new TreeNode();
        rightChildNode1.val = 9;
        rightNode.left = leftChildNode1;
        rightNode.right = rightChildNode1;
        
        // 前序非递归遍历测试
        List<Integer> list = preOrder(root);
        System.out.println("前序非递归遍历");
        list.forEach(integer -> System.out.println("integer = " + integer));

        System.out.println("====================================");

        // 前序递归遍历测试
        List<Integer> list1 = preOrderRecursion(root);
        System.out.println("前序递归遍历");
        for (Integer integer : list1) {
            System.out.println("integer = " + integer);
        }

        System.out.println("====================================");
        System.out.println();

        // 中序遍历非递归遍历测试
        List<Integer> list2 = InOrder.inOrder(root);
        System.out.println("中序非递归遍历");
        for (int i = 0; i < list2.size(); i++) {
            System.out.println("integer = " + list2.get(i));
        }

        // 中序递归方式遍历
        List<Integer> list3 = InOrder.inOrderRescursion(root);
        System.out.println("中序递归方式遍历");
        list3.forEach(integer -> System.out.println("integer = " + integer));

        System.out.println("====================================");
        System.out.println();

        // 中序递归方式遍历
        List<Integer> list5 = PostOrder.postOrderRescursion(root);
        System.out.println("后序递归方式遍历");
        list5.forEach(integer -> System.out.println("integer = " + integer));

    }
    
    

}
