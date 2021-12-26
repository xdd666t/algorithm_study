package com.study.medium.one.max_sub_array;

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//链接：https://leetcode-cn.com/problems/maximum-subarray/
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int result = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum += num;
            result = Math.max(result, sum);

            if (sum < 0) {
                sum = 0;
            }
        }
        return result;
    }
}
