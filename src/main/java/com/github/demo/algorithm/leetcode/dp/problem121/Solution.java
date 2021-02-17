package com.github.demo.algorithm.leetcode.dp.problem121;

/**
 * 121. 买卖股票的最佳时机
 *
 * @author Shawn
 * @date 2021/2/17
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        res[0] = 0;
        int min = prices[0];
        for(int i=1; i<n; i++) {
            if(prices[i] - min > res[i-1]) {
                res[i] = prices[i] - min;
            } else {
                res[i] = res[i-1];
            }
            if(prices[i] < min) min = prices[i];
        }
        return res[n-1];
    }
}