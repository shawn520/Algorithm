package others.online.pinduoduo.test1;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 思路：
 * 1. 首先找这个数时间复杂度O(n)
 *
 * 2. 使数组二有序，时间复杂度O(nlgn)
 *
 * 3.寻找合适的数。
 *
 * 注意边界条件。
 *
 *
 * @author Shawn
 * @date 2019/7/28
 */
public class Main {

    /*@Test
    public void test() {
        // 功能测试
        int [] array1 = {1, 3, 7, 4, 10};
        int [] array2 = {2, 1, 5, 8, 9};

        // 负值测试
        *//*int [] array1 = {20, 1, 23};
        int [] array2 = {50, 26, 7};*//*
        sort(array1, array2);
    }*/

    public static void sort(int[] array1, int[] array2) {
        String result = "NO";
        int length1 = array1.length;
        int length2 = array2.length;
        if(null == array1 || length1 < 2 || null == array2 || length2==0) {
            System.out.println(result);
            return;
        }

        // 1. 寻找目标数
        int index = -1;
        /*if(array1[0] > array1[1]) {
            index = 0;
        } else*/
        if(array1[length1-1] < array1[length1-2]) {
            index = length1 -1;
        } else {
            for(int i=1; i< length1-1; i++) {
                if(array1[i] < array1[i-1]) {
                    index = i;
                    break;
                }
            }
        }
        if(index == -1) {
            System.out.println(result);
            return;
        }
        int min = -2147483648;
        int max = 2147483647;

        if(index == 0) {
            max = array1[1];
        } else if(index == length1 -1) {
            min = array1[length1-2];
        } else {
            min = array1[index-1];
            max = array1[index+1];
        }

        Arrays.sort(array2);
        int index2 = -1;
        for(int k = max -1; k > min; k--) {
            index2 = Arrays.binarySearch(array2, max-1);
            if(index2 >= 0) {
                break;
            }
        }

        if(index2 >=0) {
            array1[index] = array2[index2];
            for(int i = 0; i < length1-1; i++) {
                System.out.print(array1[i]);
                System.out.print(" ");
            }
            System.out.println(array1[length1-1]);

            return;
        }
        System.out.println(result);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String input2 = in.nextLine();
        String [] input_array = input.split(" ");
        String [] input_array2 = input2.split(" ");
        int length1 = input_array.length;
        int length2 = input_array2.length;
        int [] array1 = new int[length1];
        int [] array2 = new int[length2];
        for(int i = 0; i < length1; i++) {
            array1[i] = Integer.valueOf(input_array[i]);
        }

        for(int j = 0; j < length2; j++) {
            array2[j] = Integer.valueOf(input_array2[j]);
        }
        sort(array1, array2);

        /*System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));*/
    }
}
