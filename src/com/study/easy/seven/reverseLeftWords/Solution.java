package com.study.easy.seven.reverseLeftWords;

//剑指 Offer 58 - II. 左旋转字符串
//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
//比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
//
//输入: s = "abcdefg", k = 2
//输出: "cdefgab"
//
//输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
//
//限制：
//1 <= k < s.length <= 10000
//
//链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
class Solution {
    public String reverseLeftWords(String s, int n) {
        char[] ch = s.toCharArray();
        reverse(ch, 0, n - 1);
        reverse(ch, n, ch.length - 1);
        reverse(ch, 0, ch.length - 1);
        return new String(ch, 0, ch.length);
    }

    private void reverse(char[] ch, int left, int right) {
        while (left < right) {
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;
            right--;
        }
    }
}