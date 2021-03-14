package com.github.demo.algorithm.leetcode.bit.problem1720;

/**
 * 1720. 解码异或后的数组
 *
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 *
 * 思路：encoded[i] = arr[i] XOR arr[i + 1]
 *  decoded[i+1] = decoded[i] XOR encoded[i]
 * @author Shawn
 */
class Solution {
    public int[] decode(int[] encoded, int first) {
        int len = encoded.length;
        int[] decoded = new int [len+1];
        decoded[0] = first;
        for(int i=0; i<len; i++) {
            decoded[i+1] = encoded[i] ^decoded[i];
        }
        return decoded;
    }
}