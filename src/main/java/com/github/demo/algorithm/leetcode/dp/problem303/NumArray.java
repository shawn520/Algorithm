package com.github.demo.algorithm.leetcode.dp.problem303;

/**
 * 303. 区域和检索 - 数组不可变
 *
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 *
 * @author Shawn
 * @date 2021/2/17
 */
class NumArray {
    int[] sum;

    public NumArray(int[] nums) {
        int n = nums.length;
        sum = new int[n+1];
        for(int i=0; i<n; i++) {
            sum[i+1] = sum[i] +nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */