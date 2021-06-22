package com.github.demo.algorithm.leetcode.array.problem1672;

/**
 * @author Shawn
 * @date 2021/6/22
 */
public class SolutionTest {
    public static void main(String[] args) {
        int[][] accounts = {{1,2,3},{3,2,1}};
        int money = new Solution().maximumWealth(accounts);
        System.out.println(money);
    }
}
