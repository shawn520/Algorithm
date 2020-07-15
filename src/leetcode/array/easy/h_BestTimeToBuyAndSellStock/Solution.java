package leetcode.array.easy.h_BestTimeToBuyAndSellStock;

/**
 * 分析：
 * 用两个变量：
 * minPrice记录买入的最小价格
 * maxProfit记录到当前位置最高收益
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * @author Shawn
 * @date 2020/7/15
 */
class Solution {
    public int maxProfit(int[] prices) {
        if(null == prices || prices.length ==0) return 0;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int j=0; j<prices.length; j++) {
            if(prices[j]< minPrice) minPrice = prices[j];
            else if(prices[j] - minPrice > maxProfit) {
                maxProfit = prices[j] - minPrice;
            }
        }
        return maxProfit;

    }
}
