package com.github.demo.algorithm.leetcode.array.problem215.solution2;

import java.util.Arrays;

/**
 * 堆排序
 * @author Shawn
 * @date 2020/11/29
 */
public class HeapSort {

    public  void heapsort(int [] arr){
        int len = arr.length;

        for(int i= len /2-1; i>=0; i--) {
            adjustHeap(arr, i, len);
        }

        for(int j = len-1; j>0; j--) {
            //交换
            swap(arr, 0, j);
            adjustHeap(arr, 0, j);
        }
        System.out.println(Arrays.toString(arr));


    }

    public void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i]; //先取出当前元素的值，保存在临时变量里
        //开始调整
        //说明
        //1. k = i*2+1; k是i的左子节点
        for(int k = 2 * i + 1; k<length; k = k * 2 +1) {
            if(k+1 < length && arr[k] <arr[k+1]) { //如果左子结点的值小于右子节点，k指向右节点
                k++;
            }
            if(arr[k] > temp) {
                arr[i] = arr[k]; //把较大的值赋给当前节点
                i = k; //i 指向k，继续循环比较
            } else {
                break;
            }

        }
        //当for循环结束时，我们已经将以i为父节点的树的最大值，放在了最顶上。（局部）
        arr[i] =temp; //将temp放到调整后的位置
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
