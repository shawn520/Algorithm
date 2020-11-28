package com.github.demo.algorithm.leetcode.array.problem215.solution;

import java.util.Arrays;

/**
 * @author Shawn
 * @date 2020/11/28
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        quicksort(nums, 0, len - 1);
        System.out.println(Arrays.toString(nums));
        return nums[len-k];
    }

    public void quicksort(int[] nums, int p, int q) {
        if(p<=q) {
            int r = partition(nums, p, q);
            quicksort(nums, p, r-1);
            quicksort(nums, r+1, q);
        }
    }
    public int partition(int[] nums, int p, int q) {
        //Invariant
        //[p+1, i] <=x
        //(i, j) >=x
        // [j, q] 未知
        int x = nums[p];  //pivot = a[p]
        int i = p;
        for(int j = p+1; j<=q; j++) {
            if(nums[j] < x) {
                i = i + 1;
                exch(nums, i, j);
            }
        }
        exch(nums, p, i);
        return i;
    }

    public void exch(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
