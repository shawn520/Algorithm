package com.github.demo.algorithm.leetcode.array.problem75.solution2;

/**
 * 75. Sort Colors
 *
 * @author Shawn
 * @date 2020/11/28
 */
class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if(len < 2) return ;
        //循环不变式
        //[0, p0] 0
        //(p0, i) 1  [i,p2) 未知
        //[p2, len-1] 2
        //init
        int p0 = -1;
        int i = 0;
        int p2 = len;
        while(i < p2) {
            if(nums[i] == 0) {
                p0++;
                swap(nums, p0, i);
                i++;

            } else if(nums[i] == 1) {
                i++;
            } else {
                // nums[i] == 2
                p2--;
                swap(nums, i, p2);
            }
        }
    }

    public void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}
