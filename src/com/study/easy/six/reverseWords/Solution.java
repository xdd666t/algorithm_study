package com.study.easy.six.reverseWords;

//剑指 Offer 58 - I. 翻转单词顺序
//输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
//例如输入字符串"I am a student. "，则输出"student. a am I"。
//
//输入: "the sky is blue"
//输出: "blue is sky the"
//
//输入: "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
//
//输入: "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
//
//链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder result = new StringBuilder();
        int end = s.length() - 1, start = end;
        while (start >= 0) {
            while (start >= 0 && s.charAt(start) != ' ') start--;
            result.append(s.substring(start + 1, end + 1) + " ");
            while (start >= 0 && s.charAt(start) == ' ') start--;
            end = start;
        }
        return result.toString().trim();
    }
}
