package leetcode.array.easy.c_RemoveElement;

/**
 * 思路：two pointers
 * [0, i]: !val
 * [i+1, j-1]: val
 * [j, nums.length]: uncovered
 * @author Shawn
 * @date 2020/7/14
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        int i=-1;
        for(int j=0; j<nums.length; j++)
            if(nums[j] != val) nums[++i] = nums[j];
        return i+1;

    }
}
