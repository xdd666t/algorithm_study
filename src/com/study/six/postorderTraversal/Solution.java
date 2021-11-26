package com.study.six.postorderTraversal;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
