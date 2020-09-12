package com.github.basic.leetcode.a_array.easy.o_IntersectionofTwoArraysII.solutin2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 350. Intersection of Two Arrays II
 * 分析：
 * 先遍历较短的数组
 * 时间复杂度：O(m+n)
 * 空间复杂度:O（min(m,n)）
 *
 * @author Shawn
 * @date 2020/7/19
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length >nums2.length)
            return intersect(nums2, nums1);
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int [] intersection = new int[nums1.length];
        int index = 0;
        for(int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if(count > 0) {
                intersection[index++] = num;
                count--;
                if(count>0) map.put(num, count);
                else    map.remove(num);
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
