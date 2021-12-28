package com.study.easy.three.postorderTraversal;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//145. 二叉树的后序遍历
//给定一个二叉树，返回它的 后序 遍历。
//
//输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [3,2,1]
//进阶: 递归算法很简单，你可以通过迭代算法完成吗？
//
//https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode pre = null;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.right == null || node.right == pre) {
                result.add(node.val);
                pre = node;
                node = null;
            } else {
                stack.push(node);
                node = node.right;
            }
        }
        return result;
    }

    void postorder(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }

        postorder(result, root.left);
        postorder(result, root.right);
        result.add(root.val);
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
