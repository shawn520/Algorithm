package com.github.demo.algorithm.leetcode.array.problem215.solution2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Shawn
 * @date 2020/11/29
 */
public class HeapSortTest {
    HeapSort heapSort;

    @Before
    public void init() {
        heapSort = new HeapSort();
    }

    @Test
    public void test() {
        int[] arr = {4,6,8,5,9};
        heapSort.heapsort(arr);

        int[] expected = {4, 5, 6, 8, 9};
        Assert.assertArrayEquals(arr, expected);
    }
}
