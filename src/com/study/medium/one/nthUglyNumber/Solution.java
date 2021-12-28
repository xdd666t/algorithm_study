package com.study.medium.one.nthUglyNumber;

//剑指 Offer 49. 丑数
//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
//
//输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
//
//链接：https://leetcode-cn.com/problems/chou-shu-lcof/
class Solution {
    public int nthUglyNumber(int n) {
        int index2 = 1, index3 = 1, index5 = 1;
        int[] result = new int[n + 1];
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = result[index2] * 2, num3 = result[index3] * 3, num5 = result[index5] * 5;
            result[i] = Math.min(Math.min(num2, num3), num5);
            if (result[i] == num2) index2++;
            if (result[i] == num3) index3++;
            if (result[i] == num5) index5++;
        }
        return result[n];
    }
}
