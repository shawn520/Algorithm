package com.github.demo.algorithm.leetcode.array.problem1470;

/**
 * 1470. 重新排列数组
 * @author Shawn
 */
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        int[] res = new int[len];
        int i=0;
        int j = n;
        for(int k=0; k<len; k++) {
            if(k%2==0) res[k] = nums[i++];
            else   res[k] = nums[j++];
        }
        return res;
    }
}
