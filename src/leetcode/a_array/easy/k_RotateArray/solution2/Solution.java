package leetcode.a_array.easy.k_RotateArray.solution2;

/**
 * 分析：方法二：
 * 空间换时间
 *
 * 时间复杂度：O(n)
 * 空间复杂度:O(n)
 * @author Shawn
 * @date 2020/7/18
 */
class Solution {
    public void rotate(int[] nums, int k) {
        if(k<=0) return;
        int len = nums.length;
        k = k%len;
        int r = len - k;
        int[] a = new int[k];
        for(int i=k-1; i>=0; i--) {
            a[i] = nums[r+i];
        }
        for(int j=r-1; j>=0; j--)
            nums[j+k] = nums[j];
        for(int i=0;i<k;i++)
            nums[i] = a[i];
    }
}
