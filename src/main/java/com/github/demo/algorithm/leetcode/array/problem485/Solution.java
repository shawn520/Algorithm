package com.github.demo.algorithm.leetcode.array.problem485;

import java.util.ArrayList;
import java.util.List;

/**
 * 485. 最大连续 1 的个数
 * @author Shawn
 */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cur = 0;
        for(int num : nums) {
            if(num == 1) {
                cur++;
                max = cur>max? cur:max;
            } else {
                cur = 0;
            }
        }
        return max;
    }
}
