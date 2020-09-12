package com.github.basic.java.sort;

/**
 * @author Shawn
 * @date 2019/6/30
 */
public abstract class Sort<T extends Comparable<T>> {

    public abstract void sort(int[] nums);

    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    protected void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
