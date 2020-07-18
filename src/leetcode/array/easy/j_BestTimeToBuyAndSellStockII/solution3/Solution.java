package leetcode.array.easy.j_BestTimeToBuyAndSellStockII.solution3;

/**
 * 思路：
 * 动态规划
 * 1.确定初始状态
 * 2.确定结束状态
 * 3. 状态转移
 *
 * dp 二维数组： 0，表示持有现金，1表示持有股票
 * @author Shawn
 * @date 2020/7/18
 */
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len <2) return 0;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i=0; i< len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] -prices[i]);
        }
        return dp[len-1][0];
    }
}
