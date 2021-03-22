package com.github.demo.algorithm.leetcode.bit.problem476;

/**
 * 476. 数字的补数
 *
 * 时间复杂度O(lg(n))
 * 空间复杂度O(1)
 *
 * 思路：异或操作
 * @author Shawn
 */
class Solution {
    public int findComplement(int num) {
        int bit = 0;
        int count = num;
        while(count != 0) {
            bit++;
            count = count>>1;
        }

        return num^((1<<bit)-1);
    }
}