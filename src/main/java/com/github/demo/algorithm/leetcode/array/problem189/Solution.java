package com.github.demo.algorithm.leetcode.array.problem189;

/**
 * 189. 旋转数组
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 * @author Shawn
 */
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        reverse(nums, 0, n-1);
        reverse(nums, 0, k%n-1);
        reverse(nums, k%n, n-1);
    }

    void reverse(int[] nums, int start, int end) {
        while(start<end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
