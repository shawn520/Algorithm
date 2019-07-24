package offer.group1.test11;


import org.junit.Test;

/**
 * 描述:输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Solution {

    @Test
    public void test() {

        //功能测试
//        int input = 15;

        //边界测试
//        int input = 0;

        // 负值测试
        int input = -1;

        int result =NumberOf1(input);
        System.out.println(result);
    }

    public int NumberOf1(int n) {
        int count = 0;
        while (0 != n) {
            n = n & (n-1);
            count++;
        }
        return count;
    }

}
