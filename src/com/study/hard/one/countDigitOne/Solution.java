package com.study.hard.one.countDigitOne;

//剑指 Offer 43. 1～n 整数中 1 出现的次数
//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
//
//例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
//
//输入：n = 12
//输出：5
//示例 2：
//
//输入：n = 13
//输出：6
//
//链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
class Solution {
    public int countDigitOne(int n) {
        long res = 0, high, low;
        for (long i = 1; i <= n; i *= 10) {
            high = (n / (i * 10)) * i;
            low = Math.min(Math.max(n % (i * 10) - i + 1, 0), i);
            res += (high + low);
        }
        return (int) res;
    }
}