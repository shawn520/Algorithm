package com.github.demo.algorithm.leetcode.bit.problem231;

/**
 * 231. 2的幂
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 * 思路：异或运算
 * @author Shawn
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        int num = 0;
        while(n!=0) {
            n = n & (n-1);
            num++;
        }
        return num==1;
    }
}