package leetcode.array.easy.b_RemoveDuplicatesfromSortedArray;

/**
 * @author Shawn
 * @date 2020/7/14
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        for(int j=i+1; j<nums.length; j++) {
            if(nums[i] != nums[j]) nums[++i] = nums[j];
        }
        return i+1;
    }
}
