package leetcode.array.easy.b_RemoveDuplicatesfromSortedArray;

/**
 * 思路：two pointers(i, j)
 * [0, i]：no duplicates
 * [i+1, j-1] duplicates
 * [j, nums.length) uncovered
 *
 * @author Shawn
 * @date 2020/7/14
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int i=0;
        for(int j=i+1; j<nums.length; j++) {
            if(nums[i] != nums[j]) nums[++i] = nums[j];
        }
        return i+1;
    }
}
