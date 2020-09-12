package com.github.basic.leetcode.a_array.easy.m_SingleNumber;

import java.util.Arrays;

/**
 * 分析：
 * 先排序，然后比较当前元素和左右两个元素是否相等，如果都不相等，则返回。
 *
 * 时间复杂度：O(nlgn)
 * 空间复杂度:O(1)
 * @author Shawn
 * @date 2020/7/19
 */
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if(len == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        for(int i=1; i<nums.length-1; i++) {
            if(nums[i] != nums[i-1] && nums[i] != nums[i+1]) return nums[i];
        }
        if(nums[len-1] != nums[len-2]) return nums[len-1];
        throw new IllegalArgumentException("no result");
    }
}
