package com.github.demo.algorithm.leetcode.bit.problem136;

/**
 * 136. 只出现一次的数字
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 * 思路：异或运算：任何数和自身做异或结果为0
 *
 * @author Shawn
 * @date 2021/3/14
 */
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num: nums) {
            res = res ^ num;
        }
        return res;
    }
}