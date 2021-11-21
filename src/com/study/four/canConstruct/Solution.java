package com.study.four.canConstruct;

import java.util.HashMap;
import java.util.Map;

//为了不在赎金信中暴露字迹，从杂志上搜索各个需要的字母，组成单词来表达意思。
//
//给你一个赎金信 (ransomNote) 字符串和一个杂志(magazine)字符串，判断 ransomNote 能不能由 magazines 里面的字符构成。
//
//如果可以构成，返回 true ；否则返回 false 。
//
//magazine 中的每个字符只能在 ransomNote 中使用一次。
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