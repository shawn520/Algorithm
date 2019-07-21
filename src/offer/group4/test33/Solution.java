package offer.group4.test33;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * 分析：
 *
 *
 * @author Shawn
 * @date 2019/7/20
 */
public class Solution {
    @Test
    public void test() {
        int [] numbers = {3, 32, 321};
        String result = PrintMinNumber(numbers);
        System.out.println(result);
    }

    public static String PrintMinNumber(int[] numbers) {
        if (numbers.length == 0) {
            return "";
        }

        ArrayList<Integer> list = new ArrayList<Integer>(numbers.length);
        for (Integer num : numbers) {
            list.add(num);
        }
        //排序
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (String.valueOf(o1) + String.valueOf(o2)).compareTo(String.valueOf(o2) + String.valueOf(o1));
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer num : list) {
            stringBuilder.append(""+num);
        }
        return stringBuilder.toString();
    }
}
