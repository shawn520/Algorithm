package com.github.basic.java.sort.archived.sort.b_QuickSort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 快速排序
 * 分析：
 * 使用分治法：
 * 1.Divide: 找pivot, x 将数组a[p,q]分为两个子数组，[p,pivot-1]<=x<[pivot+1,q]
 *    使用双指针，时间复杂度O(n)
 * 2.Conquer: 使用递归
 *     最坏时间复杂度：O(n)：当数组有序或者逆序时
 *     时间复杂度：O(logn)
 *  3. Combine: 经过前面两步，数组已然有序，无需Combine
 *
 *  平均时间复杂度：O(nlogn)
 *  原址排序
 * @author Shawn
 * @date 2020/7/16
 */
public class Solution {
    @Test
    public void main() {
        int [] arr = {49, 38, 65, 97, 76, 13, 27, 49};
        System.out.println("before e_sort: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("after sorted: " + Arrays.toString(arr));
    }

    void sort(int [] a) {
        quickSort(a, 0, a.length-1);
    }

    // Conquer: 递归
    private void quickSort(int[] a, int p, int q) {
        if(p<q) {
            int pivot = random_partition(a, p, q);
            quickSort(a, p, pivot-1);
            quickSort(a, pivot+1, q);
        }
    }

    /**
     * 划分
     * @param a
     * @param p
     * @param q
     * @return
     */
    public int partition(int[] a, int p, int q) {
        int x = a[p];
        int i=p;
        for(int j=i+1; j<=q; j++) {
            if(a[j]<=x) {
                i++;
                exchange(a, i, j);
            }
        }
        exchange(a, p, i);
        return i;
    }

    /**
     * 随机partition
     * @param a
     * @param p
     * @param q
     * @return
     */
    public int random_partition(int[] a, int p, int q) {
        double random = Math.random() * (q-p);
        int i = p + (int)Math.floor(random);
        exchange(a,p,i);
        return partition(a, p, q);
    }

    private void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
