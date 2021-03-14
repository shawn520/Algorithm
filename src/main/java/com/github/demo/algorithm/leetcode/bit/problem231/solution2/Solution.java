package com.github.demo.algorithm.leetcode.bit.problem231.solution2;

/**
 * 231. 2的幂
 *
 * 时间复杂度O(1)
 * 空间复杂度O(1)
 *
 * 思路：异或运算
 * @author Shawn
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        return (n & (n-1)) ==0;
    }
}