package com.github.demo.algorithm.leetcode.bit.problem191.solution2;

/**
 * 191. 位1的个数
 *
 * 时间复杂度O(1)
 * 空间复杂度O(1)
 *
 * 思路：n&(n-1)
 * @author Shawn
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while(n!=0) {
            n = n &(n-1);
            res++;
        }
        return res;
    }
}