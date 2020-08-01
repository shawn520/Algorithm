package leetcode.a_array.easy.j_BestTimeToBuyAndSellStockII.solution4;

/**
 * 动态规划改进：
 * 状态只依赖上一个状态，不需要使用二维数组
 *
 * 注意初始状态，易错
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 节省空间复杂度
 *
 * @author Shawn
 * @date 2020/7/18
 */
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2) return 0;
        int cash = 0;
        int hold = -prices[0];
        int preCash = 0;
        int preHold = hold;
        for(int i=1; i<len; i++) {
            cash = Math.max(preCash, preHold + prices[i]);
            hold = Math.max(preHold, preCash -prices[i]);

            preCash = cash;
            preHold = hold;
        }
        return cash;
    }
}
