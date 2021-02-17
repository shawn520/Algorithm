package com.github.demo.algorithm.leetcode.array.problem46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shawn
 * @date 2021/2/16
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        int len = nums.length;
        fullorder(nums, 0, results);
        return results;
    }

    /**
     * 全排列
     * @param nums 待解决的数组
     * @param depth 当前深度
     * @param results 保存结果
     */
     void fullorder(int[] nums, int depth, List<List<Integer>> results) {
        int len = nums.length;
        if(depth == len - 1) {
            List<Integer> list = new ArrayList<>();
            for(int i=0; i < len; i++) {
                list.add(nums[i]);
            }
            results.add(list);
            return;
        }
        for(int i = depth; i<len; i++) {
            int[] new_nums = Arrays.copyOf(nums, len);
            swap(new_nums, depth, i);
            fullorder(new_nums, depth+1, results);
        }
    }

    public void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
