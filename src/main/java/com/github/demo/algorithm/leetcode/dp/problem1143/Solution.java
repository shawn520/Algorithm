package com.github.demo.algorithm.leetcode.dp.problem1143;

/**
 * 1143. 最长公共子序列
 *
 * 时间复杂度O(mn)
 * 空间复杂度O(mn)
 *
 * @author Shawn
 * @date 2021/2/17
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] f = new int[m+1][n+1];
        // init
        //for(int i=0; i<=m; i++) f[i][0] = 0;
        //for(int j=0; j<=n; j++) f[0][j] = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    f[i+1][j+1] = f[i][j]+1;
                } else {
                    f[i+1][j+1] = Math.max(f[i][j+1], f[i+1][j]);
                }
            }
        }
        return f[m][n];
    }
}