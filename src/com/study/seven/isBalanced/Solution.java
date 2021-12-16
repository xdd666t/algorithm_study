package com.study.seven.isBalanced;

//剑指 Offer 55 - II. 平衡二叉树
//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
//
//
//
//示例 1:
//
//给定二叉树 [3,9,20,null,null,15,7]
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//返回 true 。
//
//示例 2:
//
//给定二叉树 [1,2,2,3,3,null,null,4,4]
//
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
//返回 false
//
//链接：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
//class Solution {
//    public boolean isBalanced(TreeNode root) {
//        if (root == null) return true;
//        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
//    }
//
//    private int depth(TreeNode root) {
//        if (root == null) return 0;
//        return Math.max(depth(root.left), depth(root.right)) + 1;
//    }
//}

class Solution {
    public boolean isBalanced(TreeNode root) {
        return recur(root) >= 0;
    }

    private int recur(TreeNode node) {
        if (node == null) return 0;

        int left = recur(node.left);
        if (left == -1) return -1;
        int right = recur(node.right);
        if (right == -1) return -1;

        return Math.abs(left - right) <= 1 ? Math.max(recur(node.left), recur(node.right)) + 1 : -1;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}