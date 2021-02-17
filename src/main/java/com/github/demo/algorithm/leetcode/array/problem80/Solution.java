package com.github.demo.algorithm.leetcode.array.problem80;

/**
 * 80. 删除排序数组中的重复项 II
 * @author Shawn
 * @date 2021/2/17
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int i=1;
        for(int j=2; j<nums.length; j++) {
            if(nums[j] != nums[i] || nums[j] != nums[i-1] ) {
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }
}
