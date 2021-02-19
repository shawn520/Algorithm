package com.github.demo.algorithm.leetcode.array.problem867;

/**
 * 867. 转置矩阵
 *
 * 时间复杂度O(mn)
 * 空间复杂度O(mn)
 *
 * @author Shawn
 * @date 2021/2/15
 */
class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int [n][m];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
