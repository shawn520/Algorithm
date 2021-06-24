package com.github.demo.algorithm.leetcode.array.problem448;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * @author Shawn
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] copy = new int[n+1];
        List<Integer> res = new ArrayList<>();
        for(int x : nums) {
            copy[x] = 1;
        }
        for(int i=1; i<n+1; i++) {
            if(copy[i]==0) {
                res.add(i);
            }
        }
        return res;
    }
}
