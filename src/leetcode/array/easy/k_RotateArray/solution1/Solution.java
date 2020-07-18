package leetcode.array.easy.k_RotateArray.solution1;

/**
 * 暴力
 * 旋转k次
 * 时间复杂度：O(k*n)
 * 空间复杂度O(1)
 * @author Shawn
 * @date 2020/7/18
 */
class Solution {
    public void rotate(int[] nums, int k) {
        if(k<=0) return;
        int len = nums.length;
        k = k%len;
        for(int i=0; i<k; i++) {
            int temp = nums[len-1];
            for(int j=len-1; j>0; j--) nums[j] = nums[j-1];
            nums[0] = temp;
        }
    }
}
