package com.github.demo.algorithm.leetcode.bit.problem1486;

/**
 * 1486. 数组异或操作
 *
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 *
 * 思路：跟着题目描述写代码
 * @author Shawn
 */
class Solution {
    public int xorOperation(int n, int start) {
        int res = 0;
        int[] nums = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = start + 2*i;
            res = res^nums[i];
        }
        return res;
    }
}