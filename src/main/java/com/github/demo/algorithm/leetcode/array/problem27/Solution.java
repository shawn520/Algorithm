package com.github.demo.algorithm.leetcode.array.problem27;

/**
 * 27. 移除元素
 * 思路：双指针
 * @author Shawn
 * @date 2021/2/17
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = -1;
        for(int j = 0; j<nums.length; j++) {
            if(nums[j] != val) {
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }
}
