package com.study.medium.eight.findContinuousSequence;

import java.util.ArrayList;
import java.util.List;

//57 - II. 和为s的连续正数序列
//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
//
//序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
//
//示例 1：
//
//输入：target = 9
//输出：[[2,3,4],[4,5]]
//示例 2：
//
//输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
//
//链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
class Solution {
    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 2, sum = 3;
        List<int[]> result = new ArrayList<>();
        while (left < right) {
            if (sum == target) {
                int[] temp = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    temp[i - left] = i;
                }
                result.add(temp);
            }

            if (sum >= target) {
                sum -= left;
                left++;
            } else {
                right++;
                sum += right;
            }
        }
        return result.toArray(new int[0][]);
    }
}