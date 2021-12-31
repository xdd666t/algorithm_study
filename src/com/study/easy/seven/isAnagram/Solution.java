package com.study.easy.seven.isAnagram;

//242. 有效的字母异位词
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
//注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
//
//
//
//示例 1:
//
//输入: s = "anagram", t = "nagaram"
//输出: true
//示例 2:
//
//输入: s = "rat", t = "car"
//输出: false
//
//链接：https://leetcode-cn.com/problems/valid-anagram/
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for (char ch : s.toCharArray()) {
            record[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            record[ch - 'a']--;
        }
        for (int num : record) {
            if (num != 0) return false;
        }
        return true;
    }
}