package com.study.three.reverseLeftWords;

//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
//该函数将返回左旋转两位得到的结果"cdefgab"。
//
//链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder result = new StringBuilder();
        for (int i = n; i < s.length() + n; i++) {
            result.append(s.charAt(i % s.length()));
        }
        return result.toString();
    }
}
