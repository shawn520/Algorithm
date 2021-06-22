package com.github.demo.algorithm.leetcode.dp.problem474;

/**
 * 474. 一和零
 *
 * 时间复杂度O(mn)
 * 空间复杂度O(mn)
 *
 * @author Shawn
 * @date 2021/2/17
 */
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[] cost_zero = new int[len];
        int[] cost_one = new int[len];
        for(int i=0; i<len; i++) {
            String str = strs[i];
            int num = Integer.valueOf(str);
            cost_one[i] = Integer.bitCount(num);
            cost_zero[i] = str.length() - cost_one[i];
        }

        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                for(int k=0; k<len; k++) {
                    if(i>cost_zero[k] && j>cost_one[k]) {
                        dp[i][j] = Math.max(dp[i][j], 1+dp[i-cost_zero[k]][j-cost_one[k]]);
                    }
                }
            }
        }

        return dp[m-1][n-1];
    }
}