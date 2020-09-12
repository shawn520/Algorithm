package com.github.basic.leetcode.a_array.easy.n_IntersectionofTwoArrays;

import java.util.HashSet;
import java.util.Set;

/**
 * 思路：
 * 两个set
 * 时间复杂度O(m+n)
 * 空间复杂度O(m+n)
 *
 * @author Shawn
 * @date 2020/7/19
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>(nums1.length);
        for(int i=0; i<nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> set2 = new HashSet<>();
        for(int j=0; j<nums2.length; j++) {
            if(set.contains(nums2[j])) set2.add(nums2[j]);
        }
        int[] res = new int[set2.size()];
        int i=0;
        for(Integer x: set2) {
            res[i++] = x;
        }
        return res;
    }
}