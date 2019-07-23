package offer.group4.test38;

import org.junit.Test;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * 思路：
 * 首先二分查找k的索引，如果不存在，返回0
 * 若存在，则向左向右求个数
 *
 * 思路二：
 * 查找k-1,k+1的插入位置。向中间靠拢。
 *
 *
 * @author Shawn
 * @date 2019/7/23
 */
public class Solution {

    @Test
    public void test() {


//        int [] array = {1,2,4,5,5,5,5,6, 9, 10};
//        int [] array = {1,3,3,3,3,4,5};

        // 功能测试
//        int count = GetNumberOfK(array, 5);

        //负值测试
//        int count = GetNumberOfK(array, 10);

        // 边界测试
        int [] array = {3};
        int count = GetNumberOfK(array, 3);

        System.out.println(count);
    }

    public int GetNumberOfK(int [] array , int k) {

        if(null == array ||array.length == 0) {
            return 0;
        }

        if(array.length ==1 && array[0] == k) {
            return 1;
        }

        // 二分查找k-1的位置
        int left = binary_sort(array, 0, array.length-1, k-1);

        //二分查找k+1的位置
        int right = binary_sort(array, left, array.length-1, k+1);

        if(left>= right) {
            return 0;
        } else {
            while (left < right) {
                if(array[left] == k) {
                    break;
                }
                left = left +1;
            }
            while (right > left) {
                if(array[right] ==k) {
                    break;
                }
                right = right -1;
            }
            if(left == right) {
                return 0;
            }

            int count = right - left +1;
            return count;
        }

    }

    public int binary_sort(int [] array, int p, int r, int k) {
        if(p < r) {
            int q = p + (r - p)/2;

            if(array[q] == k) {
                return q;
            } else if(array[q] > k) {
                return binary_sort(array, p, q-1, k);
            } else {
                return binary_sort(array, q+1, r, k);
            }

        } else {
            return p;
        }

    }
}
