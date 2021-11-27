package com.study.seven.isSymmetric;


import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        TreeNode tempA = root;
        TreeNode tempB = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tempA);
        queue.offer(tempB);
        while (!queue.isEmpty()) {
            tempA = queue.poll();
            tempB = queue.poll();
            if (tempA == null && tempB == null) {
                continue;
            }
            if ((tempA == null || tempB == null) || tempA.val != tempB.val) {
                return false;
            }

            queue.offer(tempA.left);
            queue.offer(tempB.right);

            queue.offer(tempA.right);
            queue.offer(tempB.left);
        }
        return true;
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
