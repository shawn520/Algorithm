package com.github.demo.algorithm.leetcode.array.problem26;

/**
 * 26. 删除排序数组中的重复项
 * @author Shawn
 * @date 2021/2/17
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        for(int j=1; j<nums.length; j++) {
            if(nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }
}
