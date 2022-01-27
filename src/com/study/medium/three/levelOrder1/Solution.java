package com.study.medium.three.levelOrder1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//剑指 Offer 32 - I. 从上到下打印二叉树
//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
//
//例如:
//给定二叉树: [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//返回：
//[3,9,20,15,7]
//
//链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
class Solution {
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                temp.add(node.val);
            }
            list.addAll(temp);
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val) {
        this.val = val;
    }
}