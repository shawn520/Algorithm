package com.github.demo.algorithm.leetcode.array.problem75.solution3;

/**
 * 75. 颜色分类
 *
 */
class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int i = -1, k = len;
        for(int j=0; j<k; j++) {
            if(nums[j]==0) {
                i++;
                if(i !=j) {
                    swap(nums, i, j);
                    j--;
                }
            } else if(nums[j] == 2) {
                k--;
                swap(nums, j, k);
                j--;
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}