package com.study.medium.ten.constructArr;

//66. 构建乘积数组
//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
//即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
//
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24]
//
//提示：
//所有元素乘积之和不会溢出 32 位整数
//a.length <= 100000
//
//链接：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
class Solution {
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) return a;
        int length = a.length;
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = right[a.length - 1] = 1;

        for (int i = 1; i < length; i++) {
            left[i] = a[i - 1] * left[i - 1];
        }
        for (int i = length - 2; i >= 0; i--) {
            right[i] = a[i + 1] * right[i + 1];
        }

        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}