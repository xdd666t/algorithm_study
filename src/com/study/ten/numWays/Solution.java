package com.study.ten.numWays;

//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
//
//答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//
//链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
class Solution {
    public int numWays(int n) {
        if(n < 2) return 1;

        int a = 1, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (a + b) % 1000000008;
            a = b;
            b = sum;
        }
        return sum;
    }
}
