package leetcode.a_array.easy.d_SearchInsertPosition;

/**
 * 思路：
 * 二分查找
 * 注意：判断条件是小于等于
 * @author Shawn
 * @date 2020/7/14
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length-1);
    }
    public int searchInsert(int[] nums, int target, int left, int right) {
        if(left<=right) {
            int mid = (left + right)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) return searchInsert(nums, target, left, mid-1);
            else return searchInsert(nums, target, mid+1, right);
        }
        return left;
    }
}
