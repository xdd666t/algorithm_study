package com.study.easy.two.intersect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//350. 两个数组的交集 II
//给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，
//应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
//
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
//
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9]
//
//链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int item : nums1) {
            int num = map.getOrDefault(item, 0) + 1;
            map.put(item, num);
        }
        int[] result = new int[nums2.length];
        int index = 0;
        for (int item : nums2) {
            int num = map.getOrDefault(item, 0);
            if (num > 0) {
                result[index++] = item;
                num--;
                if (num > 0) {
                    map.put(item, num);
                } else {
                    map.remove(item);
                }
            }
        }

        return Arrays.copyOfRange(result, 0, index);
    }
}
