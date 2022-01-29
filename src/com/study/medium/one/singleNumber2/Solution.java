package com.study.medium.one.singleNumber2;

import java.util.HashMap;
import java.util.Map;

//剑指 Offer 56 - II. 数组中数字出现的次数 II
//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
//
//输入：nums = [3,4,3,3]
//输出：4
//
//输入：nums = [9,1,7,9,7,9,7]
//输出：1
//
//链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) return key;
        }

        return -1;
    }
}