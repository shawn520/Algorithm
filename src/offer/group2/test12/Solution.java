package offer.group2.test12;


import org.junit.Test;

/**
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author Shawn
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(Power(2, -3));

    }

    public double Power(double base, int exponent) {
        boolean sign = true;
        if(exponent < 0) {
            sign = false;
        }
        double pos_exponent = Math.sqrt( exponent * exponent);
        double result = 1;
        while (pos_exponent > 0) {
            result = result * base;
            pos_exponent --;

        }

        if(!sign) {
            result = 1 / result;
        }
        return result;
    }
}