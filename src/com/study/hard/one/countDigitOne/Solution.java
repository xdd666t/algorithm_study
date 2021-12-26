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
        int high = n / 10, cur = n % 10, low = 0, digit = 1;
        int result = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                result += high * digit;
            } else if (cur == 1) {
                result += high * digit + low + 1;
            } else {
                result += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return result;
    }
}