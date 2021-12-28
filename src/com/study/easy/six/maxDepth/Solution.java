package com.study.easy.six.maxDepth;

import java.util.LinkedList;
import java.util.Queue;

//剑指 Offer 55 - I. 二叉树的深度
//输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
//
//给定二叉树 [3,9,20,null,null,15,7]，
//    3
//   / \
//  9  20
//    /  \
//   15   7
//返回它的最大深度 3 。
//
//链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) temp.offer(node.left);
                if (node.right != null) temp.offer(node.right);
            }
            queue = temp;
            result++;
        }
        return result;
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