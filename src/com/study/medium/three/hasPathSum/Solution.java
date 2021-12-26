package com.study.medium.three.hasPathSum;

//给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
//
//叶子节点 是指没有子节点的节点。
//
//链接：https://leetcode-cn.com/problems/path-sum

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();
            if (node.left == null && node.right == null) {
                if (num == targetSum) {
                    return true;
                }
            }

            if (node.left != null) {
                nodeQueue.offer(node.left);
                numQueue.offer(node.left.val + num);
            }

            if (node.right != null) {
                nodeQueue.offer(node.right);
                numQueue.offer(node.right.val + num);
            }
        }

        return false;
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
