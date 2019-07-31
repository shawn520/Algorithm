package offer.group4.test48;

import org.junit.Test;

/**
 * 题目描述
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、
 * if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 思路：用逻辑短路实现循环结束判断。
 *
 * @author Shawn
 * @date 2019/7/30
 */
public class Solution {

    @Test
    public void test() {
        int n = 100;
        int result = Sum_Solution(n);
        System.out.println(result);
    }

    public int Sum_Solution(int n) {
        int sum = n;
        boolean result = ((n>0) && ((sum += Sum_Solution(n-1)) > 0 ));
        return sum;

    }
}
