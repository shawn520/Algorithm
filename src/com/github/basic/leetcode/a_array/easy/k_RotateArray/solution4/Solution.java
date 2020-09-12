package com.github.basic.leetcode.a_array.easy.k_RotateArray.solution4;

/**
 * 反转数组
 * 时间复杂度：O(2n)
 * 空间复杂度：O(1)
 * @author Shawn
 * @date 2020/7/19
 */
class Solution {
    public void rotate(int[] nums, int k) {
        if(k<=0) return;
        int len = nums.length;
        k = k % len;
        rotate(nums, 0, len-1);
        rotate(nums, 0, k-1);
        rotate(nums, k, len-1);
    }

    /**
     * 反转数组
     * @param nums 数组
     * @param i 反转起始index
     * @param j 反转结束index
     */
    public void rotate(int[] nums, int i, int j) {
        while(i<j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
