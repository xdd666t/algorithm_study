package com.study.hard.one.reversePairs;

//剑指 Offer 51. 数组中的逆序对
//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
//
//示例 1:
//
//输入: [7,5,6,4]
//输出: 5
//
//链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
class Solution {
    int counts;

    public int reversePairs(int[] nums) {
        counts = 0;
        merge(nums, 0, nums.length - 1);
        return counts;
    }

    private void merge(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            merge(nums, left, mid);
            merge(nums, mid + 1, right);
            mergeSort(nums, left, mid, right);
        }
    }

    private void mergeSort(int[] nums, int left, int mid, int right) {
        int[] tempArray = new int[right - left + 1];
        int index = 0;
        int low = left, high = mid + 1;
        while (low <= mid && high <= right) {
            if (nums[low] <= nums[high]) {
                tempArray[index++] = nums[low++];
            } else {
                tempArray[index++] = nums[high++];
                counts += mid - low + 1;
            }
        }

        while (low <= mid) {
            tempArray[index++] = nums[low++];
        }
        while (high <= right) {
            tempArray[index++] = nums[high++];
        }

        for (int i = 0; i < tempArray.length; i++) {
            nums[left + i] = tempArray[i];
        }
    }
}
