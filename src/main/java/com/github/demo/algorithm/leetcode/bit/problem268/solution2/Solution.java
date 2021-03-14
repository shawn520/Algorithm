package com.github.demo.algorithm.leetcode.bit.problem268.solution2;

/**
 * 268. 丢失的数字
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 * 思路：数学求和公式
 * @author Shawn
 */
class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i=0; i< nums.length; i++) {
            sum =sum + i - nums[i];
        }
        sum += nums.length;
        return sum;
    }
}