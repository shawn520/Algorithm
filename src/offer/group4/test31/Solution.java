package offer.group4.test31;

import org.junit.Test;

/**
 * 连续子数组的最大和
 * 思路：
 * 方法1：暴力枚举，时间复杂度O(n^2)
 *
 *
 * 方法2：动态规划解决重叠子问题，自顶向下递归找思路，自底向上循环解决问题。
 * 时间复杂度O(n),空间复杂度O(1)
 *
 * @author Shawn
 * @date 2019/7/20
 */
public class Solution {

    @Test
    public void test() {
        // 功能测试
        int [] array = {6,-3,-2,7,-15,1,2,2};
//        int [] array = {1, -2, 3, 10, -4, 7, 2, -5};
        // 边界测试
//        int [] array = {};

        int result = FindGreatestSumOfSubArray(array);
        System.out.println("Max sum of sub array :" + result);
    }

    // 牛客高赞别人的解
    public  int FindGreatestSumOfSubArray(int[] array) {
        if(null == array || array.length == 0) {
            return 0;
        }
        int res = array[0]; //记录当前所有子数组的和的最大值
        int max=array[0];   //包含array[i]的连续数组最大值
        for (int i = 1; i < array.length; i++) {
            max=Math.max(max+array[i], array[i]);
            res=Math.max(max, res);
        }
        return res;
    }

    // 自底向上求解
    public int FindGreatestSumOfSubArray3(int[] array) {
        if(null == array || array.length == 0) {
            return 0;
        }
        int length = array.length;
        int max = array[0];
        int last = array[0];
        for(int i= 0; i<length; i++) {
            int current;
            if( i==0 || last <= 0) {
                current = array[i];
            } else {
                current = last + array[i];
            }
            if(current > max) {
                max = current;
            }
            last = current;

        }
        return max;
    }

    // 自顶向下递归找思路
    public int FindGreatestSumOfSubArray2(int[] array) {
        int length = array.length;
        int max = array[0];
        for(int i=0; i<length; i++) {
            int value = maxSumOfSubArray(array, i);
            if(value > max) {
                max = value;
            }
        }
        return max;
    }

    private int maxSumOfSubArray(int[] array, int i) {
        if(i==0 || maxSumOfSubArray(array,i-1) <0) {
            return array[i];
        } else {
            return maxSumOfSubArray(array,i-1) + array[i];
        }

    }

    // 方法1： 枚举
    public int FindGreatestSumOfSubArray1(int[] array) {
        if(null == array || array.length ==0) {
            return 0;
        }
        int max = array[0];
        int length = array.length;
        for(int i=0; i<length; i++) {
            int sum = 0;
            for(int j=i; j<length; j++) {
                sum = sum + array[j];
                if(sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
