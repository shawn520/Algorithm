package com.github.demo.algorithm.leetcode.array.problem561;

import java.util.Arrays;

/**
 * 561. 数组拆分 I
 *
 * 时间复杂度： O(nlgn)
 *
 * @author Shawn
 * @date 2021/2/17
 */
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0; i<nums.length; i=i+2) {
            sum += nums[i];
        }
        return sum;
    }
}
