package com.study.medium.one.permutation;

import java.util.HashSet;
import java.util.Set;

//剑指 Offer 38. 字符串的排列
//输入一个字符串，打印出该字符串中字符的所有排列。
//你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
//
//输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
//
//链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
class Solution {
    private Set<String> result = new HashSet<>();

    public String[] permutation(String s) {
        search(s.toCharArray(), new StringBuilder(), new boolean[s.length()]);
        return result.toArray(new String[0]);
    }

    void search(char[] ch, StringBuilder sb, boolean[] visited) {
        if (sb.length() == ch.length) {
            result.add(sb.toString());
        }

        for (int i = 0; i < ch.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            sb.append(ch[i]);

            search(ch, sb, visited);

            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }
}