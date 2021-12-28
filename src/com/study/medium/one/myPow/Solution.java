package com.study.medium.one.myPow;

//剑指 Offer 16. 数值的整数次方
//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
//
//输入：x = 2.00000, n = 10
//输出：1024.00000
//
//输入：x = 2.10000, n = 3
//输出：9.26100
//
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
//
//链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;

        long b = n;
        double result = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }

        while (b != 0) {
            if ((b & 1) != 0) result *= x;
            x *= x;
            b >>= 1;
        }

        return result;
    }
}