package com.github.demo.algorithm.leetcode.dp.problem53.solution2;

/**
 * 53. 最大子序和
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 * @author Shawn
 * @date 2021/2/17
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if(null == nums || nums.length<1) return 0;
        int n = nums.length;
        int tillN = nums[0];
        int max = nums[0];
        for(int i=1; i<n; i++) {
            tillN = tillN>0 ? tillN+nums[i] : nums[i];
            max = Math.max(max, tillN);
        }
        return max;
    }
}