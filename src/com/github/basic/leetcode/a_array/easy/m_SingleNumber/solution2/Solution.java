package com.github.basic.leetcode.a_array.easy.m_SingleNumber.solution2;

/**
 * 分析：
 * 异或方式
 * 原理：任何数异或0等于它本身，异或操作满足交换律和结合律
 * a异或a等于0
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 * @author Shawn
 * @date 2020/7/19
 */
class Solution {
    public int singleNumber(int[] nums) {
        for(int i=1; i<nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}
