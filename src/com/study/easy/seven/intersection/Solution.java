package com.study.easy.seven.intersection;

import java.util.HashSet;
import java.util.Set;

//349. 两个数组的交集
//给定两个数组，编写一个函数来计算它们的交集。
//
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
//
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//
//说明：
//输出结果中的每个元素一定是唯一的。
//我们可以不考虑输出结果的顺序。
//
//链接：https://leetcode-cn.com/problems/intersection-of-two-arrays/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> set = new HashSet<>();
        Set<Integer> setRes = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) setRes.add(num);
        }

        int[] res = new int[setRes.size()];
        int index = 0;
        for (int num : setRes) {
            res[index++] = num;
        }
        return res;
    }
}