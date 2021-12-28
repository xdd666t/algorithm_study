package com.study.easy.five.exchange;

//剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
//
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4]
//注：[3,1,2,4] 也是正确的答案之一。
//
//链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
class Solution {
    public int[] exchange(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            while (low < high && (nums[high] & 1) == 0) high--;
            while (low < high && (nums[low] & 1) == 1) low++;
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
        }
        return nums;
    }
}
