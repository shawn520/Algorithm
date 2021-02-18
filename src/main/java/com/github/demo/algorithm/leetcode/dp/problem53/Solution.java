package com.github.demo.algorithm.leetcode.dp.problem53;

/**
 * 53. 最大子序和
 *
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 *
 * @author Shawn
 * @date 2021/2/17
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] max = new int [n];
        int[] f = new int [n];

        max[0] = nums[0];
        f[0] = nums[0];
        for(int i=1; i<n; i++) {
            max[i] = max[i-1]>0 ? max[i-1] + nums[i] : nums[i];
            f[i] = Math.max(f[i-1], max[i]);
        }
        return f[n-1];
    }
}