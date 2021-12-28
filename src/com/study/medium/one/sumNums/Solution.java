package com.study.medium.one.sumNums;

//剑指 Offer 64. 求1+2+…+n
//求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
//
//输入: n = 3
//输出: 6
//
//输入: n = 9
//输出: 45
//
//限制：
//1 <= n <= 10000
//
//链接：https://leetcode-cn.com/problems/qiu-12n-lcof/
class Solution {
    public int sumNums(int n) {
        boolean invalid = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
