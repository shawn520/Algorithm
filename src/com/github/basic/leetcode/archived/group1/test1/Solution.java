package com.github.basic.leetcode.archived.group1.test1;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an a_array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @author Shawn
 * @date 2019/7/12
 */
class Solution {

    /**
     * bruce method.
     * Time complexity: O(n2)
     * Space complexity: O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int [] result_array = new int [2];
        for(int i=0; i < nums.length; i++) {
            for(int j=i+1; j<= nums.length; j++) {
                if(target == (nums[i] + nums[j])) {
                    result_array[0] = i;
                    result_array[1] = j;
                    return result_array;

                }
            }
        }
        return null;

    }

    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 用map存储数组值和数组下标之间的对应关系。空间换时间。
     * Time complexity: O(n)
     * Space complexity: O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int [] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i=0; i<nums.length;i++) {
            int key = target - nums[i];
            if(map.containsKey(key)){
                return new int [] {i, map.get(key)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");

    }

    /**
     * 上述方法的改进，一次遍历时间内搞定
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int [] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for(int i=0; i<nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int [] {i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
