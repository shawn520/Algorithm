package com.github.basic.leetcode.e_sort.a_MergeSortedArray;

/**
 * 88. Merge Sorted Array
 * 思路：三指针
 * 从后往前比较
 *
 * 时间复杂度:O(m+n)
 * 空间复杂度:O(1)
 * @author Shawn
 * @date 2020/8/1
 */
class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m-1;
    int j = n-1;
    int k = m+n-1;
    while(i>=0 && j>=0) {
      nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] :nums2[j--];
    }
    while(j>=0) {
      nums1[k--] = nums2[j--];
    }
  }
}
