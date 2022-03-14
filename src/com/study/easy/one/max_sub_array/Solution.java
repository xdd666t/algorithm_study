package com.study.easy.one.max_sub_array;

//53. 最大子数组和
//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//子数组 是数组中的一个连续部分。
//
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//
//输入：nums = [1]
//输出：1
//
//输入：nums = [5,4,-1,7,8]
//输出：23
//
//链接：https://leetcode-cn.com/problems/maximum-subarray/
class Solution {
    public int maxSubArray(int[] nums) {
        int temp = 0, max = nums[0];
        for (int num : nums) {
            temp = Math.max(temp + num, num);
            max = Math.max(temp, max);
        }
        return max;
    }
}
