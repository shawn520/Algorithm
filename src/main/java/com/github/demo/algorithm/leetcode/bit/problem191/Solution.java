package com.github.demo.algorithm.leetcode.bit.problem191;

/**
 * 191. 位1的个数
 *
 * 时间复杂度O(1)
 * 空间复杂度O(1)
 *
 * 思路：移位运算
 * @author Shawn
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        for(int i=0; i<32; i++) {
            res += n&1;
            n = n>>1;
        }
        return res;
    }
}