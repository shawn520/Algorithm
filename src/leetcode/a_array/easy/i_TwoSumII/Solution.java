package leetcode.a_array.easy.i_TwoSumII;

/**
 * 思路：
 * 充分利用上题目中提供的数组有序的条件
 *
 * 双指针:
 * i指向数组起始位置，j指向数组结束位置
 * i<j时执行以下步骤：
 * sum = i,j位置值相加
 * 如果sum<target, i++
 * 如果sum>target, j--
 * 如果相等，返回索引
 *
 * 如果循环结束还没有返回，说明没有满足条件的结果
 * 时间复杂度O(n),空间复杂度O(1)
 * @author Shawn
 * @date 2020/7/16
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(null == numbers) return null;
        int i=0, j = numbers.length-1;
        while(i<j) {
            int sum = numbers[i] + numbers[j];
            if(sum<target) i++;
            else if(sum>target) j--;
            else return new int[]{++i, ++j};
        }
        throw  new IllegalArgumentException();
    }
}
