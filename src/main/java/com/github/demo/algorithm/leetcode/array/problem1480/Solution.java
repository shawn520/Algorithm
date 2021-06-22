package com.github.demo.algorithm.leetcode.array.problem1480;

/**
 * 1480. 一维数组的动态和
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 * @author Shawn
 */
class Solution {
    public int[] runningSum(int[] nums) {
        for(int i=1; i<nums.length; i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }
}
