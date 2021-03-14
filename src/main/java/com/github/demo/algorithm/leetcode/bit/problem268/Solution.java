package com.github.demo.algorithm.leetcode.bit.problem268;

/**
 * 268. 丢失的数字
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 * 思路：跟下标异或运算
 * @author Shawn
 */
class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        for(int i=0; i< nums.length; i++) {
            res = res^nums[i]^i;
        }
        return res^nums.length;
    }
}