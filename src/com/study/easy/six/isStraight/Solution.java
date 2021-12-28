package com.study.easy.six.isStraight;

import java.util.HashSet;
import java.util.Set;

//61. 扑克牌中的顺子
//从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
//可以看成任意数字。A 不能视为 14。
//
//输入: [1,2,3,4,5]
//输出: True
//
//输入: [0,0,1,2,5]
//输出: True
//
//链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
class Solution {
    public boolean isStraight(int[] nums) {
        int min = 14, max = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num == 0) continue;
            max = Math.max(num, max);
            min = Math.min(num, min);
            if (set.contains(num)) return false;
            set.add(num);
        }
        return max - min < 5;
    }
}