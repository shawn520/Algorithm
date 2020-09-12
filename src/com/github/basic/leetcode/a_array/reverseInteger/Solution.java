package com.github.basic.leetcode.a_array.reverseInteger;

/**
 * @author Shawn
 * @date 2020/6/27
 */
public class Solution {
    public int reverse(int x) {
        long res = 0;
        for(; x != 0; x /= 10) {
            res = res * 10 + x % 10;
        }
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0:  (int)res;
    }
}
