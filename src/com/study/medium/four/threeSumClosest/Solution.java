package com.study.medium.four.threeSumClosest;

import java.util.Arrays;

//16. 最接近的三数之和
//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
//返回这三个数的和。
//假定每组输入只存在恰好一个解。
//
//示例 1：
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
//示例 2：
//输入：nums = [0,0,0], target = 1
//输出：0
//
//提示：
//3 <= nums.length <= 1000
//-1000 <= nums[i] <= 1000
//-104 <= target <= 104
//
//链接：https://leetcode-cn.com/problems/3sum-closest/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = 999999;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) return target;
                if (Math.abs(sum - target) < Math.abs(res - target)) res = sum;
                if (sum < target) {
                    while (left < right && nums[left] == nums[++left]) ;
                } else {
                    while (left < right && nums[right] == nums[--right]) ;
                }
            }
        }
        return res;
    }
}
