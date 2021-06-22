package com.github.demo.algorithm.leetcode.array.problem1672;

/**
 * 1672. 最富有客户的资产总量
 * 时间复杂度O(mn)
 * @author Shawn
 */
class Solution {
    public int maximumWealth(int[][] accounts) {
        int banks = accounts[0].length;
        int clients = accounts.length;
        int max = 0;
        for(int i=0; i<clients; i++) {
            int money = 0;
            for(int j=0; j<banks; j++) {
                money +=accounts[i][j];
            }
            if(money>max) max = money;
        }
        return max;
    }
}
