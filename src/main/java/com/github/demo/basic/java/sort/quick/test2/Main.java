package com.github.demo.basic.java.sort.quick.test2;

import java.util.Arrays;

/**
 * 快排的随机化版本
 * @author Shawn
 * @date 2019/8/25
 */
public class Main {
    public static void main(String[] args) {
        int [] array = {8,4,5,2,5,7,8,6};
        System.out.println("排序前数组:" + Arrays.toString(array));
        sort(array);
        System.out.println("排序后数组:" + Arrays.toString(array));
    }

    public static void sort(int [] a) {
        quicksort(a, 0 , a.length-1);
    }

    public static void quicksort(int [] a, int p, int r) {
        if(p<r) {
            int q = randomPartition(a, p, r);
            quicksort(a, p, q-1);
            quicksort(a, q+1, r);
        }
    }

    public static int randomPartition(int [] a, int p, int r) {
        int random = p + (r-p) * (int)(Math.random());
        swap(a, random, r);
        return partition(a, p, r);
    }

    public static int partition(int [] a, int p, int r) {
        int x = a[r];
        int i = p-1;
        for(int j=p; j <r; j++) {
            if(a[j] < x) {
                i++;
                swap(a,i,j);
            }
        }
        swap(a, i+1, r);
        return i+1;
    }

    public static void swap(int [] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
