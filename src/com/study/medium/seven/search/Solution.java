package com.study.medium.seven.search;

//53 - I. 在排序数组中查找数字 I
//统计一个数字在排序数组中出现的次数。
//
//示例 1:
//输入: nums = [5,7,7,8,8,10], target = 8 输出: 2
//示例 2:
//输入: nums = [5,7,7,8,8,10], target = 6 输出: 0
//
//链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
class Solution {
    public int search(int[] nums, int target) {
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false) - 1;

        if (left <= right && right < nums.length && nums[left] == target && nums[right] == target) {
            return right - left + 1;
        }

        return 0;
    }

    private int binarySearch(int[] nums, int target, boolean low) {
        int left = 0, right = nums.length - 1, result = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (low && nums[mid] == target)) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}


