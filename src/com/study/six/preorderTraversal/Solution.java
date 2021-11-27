package com.study.six.preorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
//https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                result.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return result;
    }

    void preorder(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        preorder(result, root.left);
        preorder(result, root.right);
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
