package com.study.easy.two.generate;

import java.util.ArrayList;
import java.util.List;

//118. 杨辉三角
//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
//在「杨辉三角」中，每个数是它左上方和右上方的数的和。
//
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//
//输入: numRows = 1
//输出: [[1]]
//
//链接：https://leetcode-cn.com/problems/pascals-triangle/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    subList.add(1);
                } else {
                    subList.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(subList);
        }
        return result;
    }
}