package com.study.medium.two.findNthDigit;

//剑指 Offer 44. 数字序列中某一位的数字
//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
//请写一个函数，求任意第n位对应的数字。
//
//输入：n = 3
//输出：3
//
//输入：n = 11
//输出：0
//
//链接：https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
class Solution {
    public int findNthDigit(int n) {
        if (n < 10) return n;
        int digit = 1;
        long start = 1, count = 10;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = 9 * start * digit;
        }
        long num = start + n / digit;
        return Long.toString(num).charAt(n % digit) - '0';
    }
}