package com.study.easy.four.firstUniqChar;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//剑指 Offer 50. 第一个只出现一次的字符
//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
//
//输入：s = "abaccdeff"
//输出：'b'
//
//输入：s = ""
//输出：' '
//
//链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/solution/
class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, i);
                queue.offer(ch);
            } else {
                map.put(ch, -1);
                while (!queue.isEmpty() && map.get(queue.peek()) == -1) {
                    queue.poll();
                }
            }
        }

        return queue.isEmpty() ? ' ' : queue.poll();
    }
}