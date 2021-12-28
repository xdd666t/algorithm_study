package com.study.medium.one.movingCount;

import java.util.LinkedList;
import java.util.Queue;

//剑指 Offer 13. 机器人的运动范围
//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
//也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
//因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
//
//输入：m = 2, n = 3, k = 1
//输出：3
//
//输入：m = 3, n = 1, k = 0
//输出：1
//
//链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
class Solution {
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }

        int[] dx = new int[]{0, 1};
        int[] dy = new int[]{1, 0};
        boolean[][] mark = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int result = 1;
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; i++) {
                int tx = dx[i] + x, ty = dy[i] + y;
                if (tx >= m || ty >= n || getSum(tx) + getSum(ty) > k || mark[tx][ty]) {
                    continue;
                }
                queue.offer(new int[]{tx, ty});
                mark[tx][ty] = true;
                result++;
            }
        }
        return result;
    }

    int getSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
