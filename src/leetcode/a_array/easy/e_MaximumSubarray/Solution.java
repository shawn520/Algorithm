package leetcode.a_array.easy.e_MaximumSubarray;

/**
 * 分析：
 * 用两个变量：
 * maxSoFar: 记录到当前索引最后一个元素最大的值， =max(maxSoFar+nums[i], nums[i])
 * maxOfAll: 记录到当前索引最大的值 = max(maxSoFar, maxOfAll)
 * 时间复杂度：O(n)
 * 空间复杂度:O(1)
 * @author Shawn
 * @date 2020/7/14
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int maxSoFar = nums[0];
        int maxOfAll = nums[0];
        for(int i=1; i<nums.length; i++) {
            maxSoFar = Math.max(maxSoFar+nums[i], nums[i]);
            maxOfAll = Math.max(maxSoFar, maxOfAll);
        }
        return maxOfAll;

    }
}
