package com.github.basic.leetcode.a_array.easy.g_MergeSortedArray;

/**
 * 分析：
 * 用三个指针i,j,k分别指向数组1，数组2，以及合并后的数组中最大的值
 * 当i,j都大于等于0时，将两个数组中最大的值拷贝到k--位置
 * 当数组2中还有元素时，将数组2中的元素拷贝到数组1
 * 时间复杂度：O(m+n)
 * 空间复杂度：O(1)
 *
 * @author Shawn
 * @date 2020/7/15
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m + n - 1;
        while(i>=0 && j>=0) {
            nums1[k--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
        }
        while(j>=0) {
            nums1[k--] = nums2[j--];
        }
    }
}
