package com.study.five.myPow;

//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
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