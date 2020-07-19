package leetcode.array.easy.o_IntersectionofTwoArraysII.solution3;

import java.util.Arrays;

/**
 * 分析：
 * 排序
 * 1. 分别将两个数组排序，时间复杂度O(mlgm + nlgn)
 * 2. i，j指针分别指向两个数组，遍历数组
 * 如果相等，则两个指针后移，元素添加到输入数组
 * 如果不相等，元素小的指针后移，继续遍历。
 *
 * 时间复杂度: O(mlgm + nlgn)
 * 空间复杂度：O(min(m,n))
 * @author Shawn
 * @date 2020/7/19
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1= nums1.length;
        int length2 = nums2.length;
        int i=0,j=0;
        int[] intersection = new int[Math.min(length1, length2)];
        int k = 0;
        while(i<length1 && j<length2) {
            if(nums1[i] < nums2[j]) i++;
            else if(nums1[i] > nums2[j]) j++;
            else {
                intersection[k] = nums1[i];
                i++;
                j++;
                k++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, k);
    }
}
