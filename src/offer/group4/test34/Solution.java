package offer.group4.test34;

import org.junit.Test;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 分析：
 * 逐个判断每个数是不是丑数，时间复杂度高。
 *
 * 丑数的2，3，5倍依然是偶数，将范围内的所有丑数排好序，根据索引寻找。
 * 关键：如何使其有序？
 * 用三个下标分别记录每个丑数的2，3，5倍位置。每次选对应值最小的数作为下一个丑数。
 *
 *
 * @author Shawn
 * @date 2019/7/21
 */
public class Solution {

    @Test
    public void test() {
        // 功能测试
        int index = 11;

        // 边界测试
//        int index = 3;

        // 负值测试
//        int index = -1;

        int result = GetUglyNumber_Solution(index);
        System.out.println(result);
    }

    public int GetUglyNumber_Solution(int index) {
        if(index <=0) {
            return 0;
        }
        int [] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;

        int next = 1;
        int mul2 = 0;
        int mul3 = 0;
        int mul5 = 0;

        while (next < index ) {
            int data = min(uglyNumbers[mul2] * 2, uglyNumbers[mul3] * 3, uglyNumbers[mul5] * 5);
            uglyNumbers[next] = data;
            while (uglyNumbers[mul2] * 2 <= uglyNumbers[next]) {
                mul2++;
            }

            while (uglyNumbers[mul3] * 3 <= uglyNumbers[next]) {
                mul3++;
            }

            while (uglyNumbers[mul5] * 5 <= uglyNumbers[next]) {
                mul5++;
            }
            next++;

        }

        int ugly = uglyNumbers[index-1];
        return ugly;
    }

    public int min(int a, int b, int c) {
        int min = a;
        if(b < min) {
            min = b;
        }
        if(c < min) {
            min = c;
        }
        return min;
    }


    // 逐个判断是不是丑数
    public int GetUglyNumber_Solution1(int index) {
        int result= index;
        if(index < 0) {
            return -1;
        }
        if(index < 7) {
            return result;
        } else {
            int count = 6;

            for(int i = 7; count < index; i++) {
                result = i;
                int num = i;

                while (num % 2 ==0) {
                    num /= 2;
                }
                while (num % 3 ==0) {
                    num /= 3;
                }
                while (num % 5 ==0) {
                    num /= 5;
                }

                if(num == 1) {
                    count++;
                }

            }


        }
        return result;
    }
}
