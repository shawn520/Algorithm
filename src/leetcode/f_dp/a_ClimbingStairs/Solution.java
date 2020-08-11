package leetcode.f_dp.a_ClimbingStairs;

/**
 * 70. Climbing Stairs
 * 分析：
 * 爬第n阶台阶方法 = 爬第n-1阶的方法 + 爬第n-2阶的方法
 *
 * 时间复杂度：O(n)
 * 空间复杂度: O(n)
 * @author Shawn
 * @date 2020/8/11
 */
class Solution {
  public int climbStairs(int n) {
    if(n==1) return 1;
    if(n==2) return 2;
    return climbStairs(n-1) + climbStairs(n-2);
  }
}
