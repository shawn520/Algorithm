package offer.group4.test43;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，
 * 输出两个数的乘积最小的。
 *
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 *
 * 思路：首先二分法查找S的插入位置，
 * 然后i指向数组的左边，j指向待插入位置的左边。
 * 如果a[i] + a[j] > S, 则j--
 * 如果a[i] + a[j] < S, 则i++
 *
 *
 * @author Shawn
 * @date 2019/7/27
 */
public class Solution {
    private static final Integer SIZE = 2;

    @Test
    public void test() {
        int [] array = {1,2,4,7,11,16};
        int sum = 17;
        ArrayList<Integer> result = FindNumbersWithSum(array, sum);
        System.out.println(result);
    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>(SIZE);
        if(null == array || array.length <SIZE) {
            return result;
        }
        int left = 0;
        int right = array.length;
        int index = binarySearch(array, left, right, sum);


        int i = 0, j = index-1;
        while (i<j) {
            int value = array[i] + array[j];
            if(value == sum) {
                result.add(array[i]);
                result.add(array[j]);
                break;
            } else if( value >sum) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }

    // 二分查找
    public int binarySearch(int [] array, int left, int right, int sum) {
        if(left < right) {
            int mid = left + (right - left)/2;
            if(array[mid] == sum) {
                return mid;
            } else if(array[mid] >sum) {
                binarySearch(array, left, mid-1, sum);
            } else {
                binarySearch(array, mid+1, right, sum);
            }
        }
        // 没有则返回待插入右边的位置
        return right;
    }
}
