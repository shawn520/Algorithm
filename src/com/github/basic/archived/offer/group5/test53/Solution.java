package com.github.basic.archived.offer.group5.test53;

import org.junit.Test;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * 分析：
 * 一定要考虑各种情况。
 * 分为科学计数法，和小数两种特殊情况。
 * 小数里面还需判断是否是科学计数法。
 *
 * @author Shawn
 * @date 2019/8/3
 */
public class Solution {

    @Test
    public void test() {

        // 功能测试
        /*char[] str = {'+', '1', '0', '0'};
        char[] str2 = {'5', 'e', '2'};
        char[] str3 = {'-', '1', '2', '3'};
        char[] str4 = {'3', '.', '1', '4'};
        char[] str5 = {'-', '1', 'E', '-', '6'};
        boolean result = isNumeric(str);
        boolean result2 = isNumeric(str2);
        boolean result3 = isNumeric(str3);
        boolean result4 = isNumeric(str4);
        boolean result5 = isNumeric(str5);

        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);

        // 反例测试
        char[] str11 = {'1', '2', 'e'};
        char[] str22 = {'1', 'a', '3', '.', '1'};
        char[] str33 = {'1', '.', '2', '.'};
        char[] str44 = {'+', '-', '5', '4'};
        char[] str55 = {'1', 'e', '+', '4', '.', '3'};
        boolean result11 = isNumeric(str11);
        boolean result22 = isNumeric(str22);
        boolean result33 = isNumeric(str33);
        boolean result44 = isNumeric(str44);
        boolean result55 = isNumeric(str55);
        System.out.println(result11);
        System.out.println(result22);
        System.out.println(result33);
        System.out.println(result44);
        System.out.println(result55);*/

        char[] str = {'1', '.', '3', 'e', '+', '6'};
        boolean result = isNumeric(str);
        System.out.println(result);
    }

    public boolean isNumeric(char[] str) {

        if(null == str || 0 == str.length) {
            return false;
        }

        if(1 == str.length) {
            if(str[0] >='0' && str[0] <='9') {
                return true;
            } else {
                return false;
            }
        }
        int i = 0;
        if(str[0] == '+' || str[0] == '-')  {
            i++;
        }

        while (i < str.length) {
            if(str[i] >= '0' && str[i] <= '9') {
                i++;
            } else if(str[i] == 'e' || str[i] == 'E') {
                return isScientificNotation(str, i);
            } else if(str[i] == '.') {
                return isDecimal(str, i);
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * 判断是否是科学计数法
     * @param str
     * @param i
     * @return
     */
    public boolean isScientificNotation(char[] str, int i) {
        // 到e截至返回false;
        if(i == str.length - 1) {
            return false;
        }
        // 如何i为倒数第二个字符
        if(i+1 == str.length -1) {
            // 如果0-9之间返回true，否则返回false
            if(str[i+1] >= '0' && str[i+1] <= '9' ) {
                return true;
            } else {
                return false;
            }
        }
        i++;
        if(str[i] == '+' || str[i] == '-') {
            i++;
        }
        while (i < str.length) {
            if(str[i] >= '0' && str[i] <= '9') {
                i++;
            } else {
                return false;
            }

        }
        return true;
    }

    /**
     * 判断是否是小数
     * @param str
     * @param i
     * @return
     */
    public boolean isDecimal(char[] str, int i) {
        if(i == str.length - 1) {
            return false;
        }
        i++;
        while (i < str.length) {
            if(str[i] >= '0' && str[i] <= '9') {
                i++;
            } else if(str[i] == 'e' || str[i] == 'E') {
                return isScientificNotation(str, i);
            } else {
                return false;
            }

        }
        return true;

    }
}
