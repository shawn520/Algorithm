package leetcode.array.easy.l_ContainsDuplicate.solution2;

import java.util.Arrays;

/**
 * 分析：
 * 1.先排序
 *  排序后相同元素相邻
 *
 *  时间复杂度：排序的时间复杂度O(nlgn)
 *  空间复杂度：O(1)
 * @author Shawn
 * @date 2020/7/19
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] == nums[i+1]) return true;
        }
        return false;
    }
}
