package archived.offer.group3.test30;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4。
 *
 * 分析：考察排序
 * 使用快排的随机化版本
 *
 * 时间复杂度O(nlgn)
 *
 * @author Shawn
 * @date 2019/7/19
 */
public class Solution {

    @Test
    public void test() {
        // 功能测试
        //int [] input = {4,5,1,6,2,7,3,8};
        int [] input = {2,8,7,1,3,5,6,4};
        sort(input);
        System.out.println(input);

    }

    public void sort(int [] input) {
        quicksort(input, 0, input.length-1);

    }

    private void quicksort(int[] input, int left, int right) {

        if(left < right) {
            int q =randomPartition(input, left, right);
            quicksort(input, left, q-1);
            quicksort(input, q+1, right);
        }
    }

    private int randomPartition(int[] a, int p, int r) {
        int random = (int)(Math.floor(Math.random() * r)) ;
        swap(a, r, random);
        return partition(a, p, r);
    }

    private int partition(int[] input, int left, int right) {

        int x = input[right];

        int i = left - 1;
        for(int j = left; j<right; j++) {
            if(input[j] <= x) {
                i++;
                swap(input, i, j);
            }

        }
        swap(input, i+1, right);
        return i+1;
    }

    private void swap(int[] input, int i, int j) {
        int t = input[i];
        input[i] = input[j];
        input[j] = t;
    }



    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> result = new ArrayList<>();
        sort(input);

        if(k > input.length) {
            return  result;
        }

        for(int i=0; i<k; i++) {
            result.add(input[i]);
        }
        return result;


    }
}
