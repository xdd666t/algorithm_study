package com.study.medium.two.intersect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 给定两个数组，编写一个函数来计算它们的交集
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
// 我们可以不考虑输出结果的顺序。
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
