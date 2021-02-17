package com.github.demo.algorithm.leetcode.array.problem283.solution2;

/**
 * 283. Move Zeroes
 *
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 *
 *
 * @author Shawn
 * @date 2021/2/15
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int i = -1;
        for(int j=0; j<nums.length; j++) {
            if(nums[j] != 0) {
                nums[++i] = nums[j];
            }
        }
        while(i<nums.length-1) {
            nums[++i] = 0;
        }
    }
}
