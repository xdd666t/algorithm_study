package com.study.easy.five.maxSubArray;

//剑指 Offer 42. 连续子数组的最大和
//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
//要求时间复杂度为O(n)。
//
//输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
//链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0], pre = 0;
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            result = Math.max(pre, result);
        }
        return result;
    }
}