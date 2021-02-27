package com.github.demo.algorithm.leetcode.dp.problem746.solution2;

/**
 * 746. 使用最小花费爬楼梯
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 * @author Shawn
 * @date 2021/2/17
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int a = 0,b=0,c=0;
        for(int i=0; i<n-1; i++) {
            c = Math.min(a + cost[i], b + cost[i+1]);
            a = b;
            b = c;
        }
        return c;
    }
}