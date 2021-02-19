package com.github.demo.algorithm.leetcode.dp.problem1025;

/**
 * 1025. 除数博弈
 *
 * 时间复杂度O(1)
 * 空间复杂度O(1)
 *
 * @author Shawn
 * @date 2021/2/17
 */
class Solution {
    public boolean divisorGame(int N) {
        if(N<=0) return false;
        return N%2==0;
    }
}