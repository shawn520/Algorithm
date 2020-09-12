package com.github.basic.java.sort.bubble;

/**
 * 冒泡排序的优化版
 * @author Shawn
 * @date 2019/7/22
 */
public class Bubble {
    public int bubble_sort(int [] array) {
        int times = 0;
        int length = array.length;

        for(int i=0; i<length; i++) {
            boolean sorted = true;
            for(int j=0; j<length-i-1; j++) {
                if(array[j] > array[j+1]) {
                    swap(array, j, j+1);
                    times++;
                    sorted = false;
                }
            }
            if(sorted) {
                break;
            }
        }
        return times;
    }

    public void swap(int [] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }
}
