package com.study.eight.verifyPostorder;

//剑指 Offer 33. 二叉搜索树的后序遍历序列
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
//
//参考以下这颗二叉搜索树：
//
//     5
//    / \
//   2   6
//  / \
// 1   3
//示例 1：
//
//输入: [1,6,3,2,5]
//输出: false
//示例 2：
//
//输入: [1,3,2,6,5]
//输出: true
//
//链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    boolean recur(int[] postorder, int left, int right) {
        if (left >= right) return true;
        int mid = left;
        int root = postorder[right];
        while (postorder[mid] < root) mid++;
        int temp = mid;
        while (temp < right) {
            if (postorder[temp] < root) return false;
            temp++;
        }
        return recur(postorder, left, mid - 1) && recur(postorder, mid, right - 1);
    }
}
