package com.github.basic.leetcode.a_array.easy.j_BestTimeToBuyAndSellStockII.solution1;

/**
 * 暴力搜索
 *
 * 分析：
 * 注意状态转换：
 * 1. 不改变
 * 2. 如果不持有股票，可以买入
 * 2. 如果持有股票，可以卖出
 * @author Shawn
 * @date 2020/7/18
 */
class Solution {

    private int res;

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len<2) return 0;
        this.res = 0;
        dfs(prices, 0, len, 0, res);
        return this.res;
    }

    public void dfs(int[] prices, int index, int len, int status, int profit) {
        if(index == len) {
            this.res = Math.max(this.res, profit);
        }
        dfs(prices, index+1, len, status, profit);
        if(status == 0) {
            dfs(prices, index+1, len, 1, profit-prices[index]);
        } else {
            dfs(prices, index+1, len, 0, profit+prices[index]);
        }
    }
}
