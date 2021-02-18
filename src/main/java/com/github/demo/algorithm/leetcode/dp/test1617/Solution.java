package com.github.demo.algorithm.leetcode.dp.test1617;

/**
 * 面试题 17.16. 按摩师
 *
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 *
 * @author Shawn
 * @date 2021/2/17
 */
class Solution {
    public int massage(int[] nums) {
        if(null == nums) return -1;
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];

        int[] res = new int [n];
        res[0] = nums[0];
        res[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<n; i++) {
            res[i] = Math.max(res[i-1], res[i-2] + nums[i]);
        }
        return res[n-1];
    }
}