package com.study.easy.two.canConstruct;

import java.util.HashMap;
import java.util.Map;

//383. 赎金信
//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
//如果可以，返回 true ；否则返回 false 。
//magazine 中的每个字符只能在 ransomNote 中使用一次。
//
//输入：ransomNote = "a", magazine = "b"
//输出：false
//
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
//
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
//
//链接：https://leetcode-cn.com/problems/ransom-note
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.getOrDefault(c, 0) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}