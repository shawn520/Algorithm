package basic.sort.a_InsertSort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 插入排序
 * 分析：
 * 时间复杂度O(n2)
 * 空间复杂度O(1)
 * @author Shawn
 * @date 2020/7/15
 */
public class Solution {
    @Test
    public void main() {
        int [] arr = {49, 38, 65, 97, 76, 13, 27, 49};
        System.out.println("before sort: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("after sorted: " + Arrays.toString(arr));
    }

    void sort(int [] a) {
        insertSort(a);
    }
    void insertSort(int [] a) {
        for(int i=1; i<a.length; i++) {
            int j = i-1;
            int temp = a[i];
            while (j>=0 && temp < a[j]) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = temp;
        }
    }
}
