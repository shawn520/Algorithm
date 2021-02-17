package com.github.demo.algorithm.leetcode.dp.problem70;

/**
 * 70. 爬楼梯
 *
 * @author Shawn
 * @date 2021/2/17
 */
class Solution {
    public int climbStairs(int n) {
        int[] res = new int[n];
        res[0] = 1;
        if(n>=2) res[1] = 2;
        for(int i=2; i<n; i++) {
            res[i] = res[i-1] + res[i-2];
        }
        return res[n-1];
    }
}