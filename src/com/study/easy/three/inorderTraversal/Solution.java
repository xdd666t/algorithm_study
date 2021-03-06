package com.study.easy.three.inorderTraversal;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//94. 二叉树的中序遍历
//给定一个二叉树的根节点 root ，返回它的 中序 遍历。
//
//输入：root = [1,null,2,3]
//输出：[1,3,2]
//
//输入：root = []
//输出：[]
//
//输入：root = [1]
//输出：[1]
//
//输入：root = [1,2]
//输出：[2,1]
//
//输入：root = [1,null,2]
//输出：[1,2]
//
//https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()){
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }

        return result;
    }

    void inorder(List<Integer> result, TreeNode root) {
        if (result == null) {
            return;
        }

        inorder(result, root.left);
        result.add(root.val);
        inorder(result, root.right);
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
