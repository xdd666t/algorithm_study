package com.study.nine.lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

//48. 最长不含重复字符的子字符串
//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
//
//输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//
//请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] ch = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int temp = 0;
        for (int i = 0; i < ch.length; i++) {
            int index = map.getOrDefault(ch[i], -1);
            map.put(ch[i], i);
            temp = temp < i - index ? temp + 1 : i - index;
            result = Math.max(result, temp);
        }
        return result;
    }
}