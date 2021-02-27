package com.github.demo.algorithm.leetcode.dp.problem746;

/**
 * 746. 使用最小花费爬楼梯
 *
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 *
 * @author Shawn
 * @date 2021/2/17
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int [n+1];
        for(int i=0; i<n-1; i++) {
            dp[i+2] = Math.min(dp[i] + cost[i], dp[i+1] + cost[i+1]);
        }
        return dp[n];
    }
}