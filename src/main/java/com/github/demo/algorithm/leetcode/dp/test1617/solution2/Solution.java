package com.github.demo.algorithm.leetcode.dp.test1617.solution2;

/**
 * 面试题 17.16. 按摩师
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
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

        int res1 = nums[0];
        int res2 = Math.max(nums[0], nums[1]);
        int res3 =Math.max(res1, res2);
        for(int i=2; i<n; i++) {
            res3 = Math.max(res2, res1 + nums[i]);
            res1 = res2;
            res2 = res3;
        }
        return res3;
    }
}