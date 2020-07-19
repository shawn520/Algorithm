package leetcode.array.easy.p_MoveZeroes;

/**
 * 283. Move Zeroes
 * 分析：
 * 双指针i,j
 * [0,i] 非0
 * (i,j) 0
 * [j, n) 未遍历
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * @author Shawn
 * @date 2020/7/19
 */
class Solution {
    public void moveZeroes(int[] nums) {
        for(int i=-1, j=0; j<nums.length; j++) {
            if(nums[j] !=0) {
                int temp = nums[++i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
}
