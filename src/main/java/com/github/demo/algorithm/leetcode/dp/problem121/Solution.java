package com.github.demo.algorithm.leetcode.dp.problem121;

/**
 * 121. 买卖股票的最佳时机
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 * @author Shawn
 * @date 2021/2/17
 */
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = prices[0];
        for(int i=1; i<prices.length; i++) {
            if(prices[i] - min > maxProfit) {
                maxProfit = prices[i] - min;
            }
            if(prices[i] < min) min = prices[i];
        }
        return maxProfit;
    }
}