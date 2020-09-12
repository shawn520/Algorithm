package com.github.basic.archived.offer.group1.test13;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author Shawn
 * @date 2019/6/23
 */
public class Solution {

    @Test
    public void test() {
        int [] array = {1,2,4,5,6,7,9};
        reOrderArray(array);
        for(int i =0; i< array.length; i++ ) {
            System.out.print(array[i] + "\t");

        }
        System.out.println();

    }

    public void reOrderArray(int [] array) {

        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if( array[i] % 2 ==1) {
                odd.add(array[i]);

            } else {
                even.add(array[i]);
            }
        }

        for(int i = 0; i < odd.size(); i++) {
            array[i] = odd.get(i);
        }

        int j = odd.size();
        for (int i = 0; i < even.size(); i++) {
            array[j+i] = even.get(i);
        }

    }
}
