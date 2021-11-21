package com.study.three.maxProfit;

//给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
//
//你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
//
//返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
//链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int item : prices) {
            if (item < minPrice) {
                minPrice = item;
            } else if (item - minPrice > maxProfit) {
                maxProfit = item - minPrice;
            }
        }
        return maxProfit;
    }
}