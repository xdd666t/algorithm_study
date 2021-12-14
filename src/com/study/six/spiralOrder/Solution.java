package com.study.six.spiralOrder;

//29. 顺时针打印矩阵
//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//
//示例 1：
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]] 输出：[1,2,3,6,9,8,7,4,5]
//示例 2：
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]] 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//限制：
//● 0 <= matrix.length <= 100
//● 0 <= matrix[i].length <= 100
//
//链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = 0;
        boolean[][] mark = new boolean[rows][columns];
        int[] result = new int[rows * columns];
        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = matrix[row][column];
            mark[row][column] = true;

            int nextRow = row + direction[directionIndex][0];
            int nextColumn = column + direction[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || mark[nextRow][nextColumn]) {
                directionIndex = ++directionIndex % 4;
            }
            row += direction[directionIndex][0];
            column += direction[directionIndex][1];
        }
        return result;
    }
}