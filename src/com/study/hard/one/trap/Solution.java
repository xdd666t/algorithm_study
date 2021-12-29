package com.study.hard.one.trap;

//42. 接雨水
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
//链接：https://leetcode-cn.com/problems/trapping-rain-water/
class Solution {
    public int trap(int[] height) {
        int left = 1, right = height.length - 2;
        int leftMax = height[0], rightMax = height[height.length - 1];
        int res = 0;

        while (left <= right) {
            if (leftMax < rightMax) {
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
