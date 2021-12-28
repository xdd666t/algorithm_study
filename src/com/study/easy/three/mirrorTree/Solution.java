package com.study.easy.three.mirrorTree;

//剑指 Offer 27. 二叉树的镜像
//请完成一个函数，输入一个二叉树，该函数输出它的镜像。
//
//例如输入：
//     4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
//镜像输出：
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1
//
//输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
//
//链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
