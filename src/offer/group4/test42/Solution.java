package offer.group4.test42;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,
 * 他马上就写出了正确答案是100。但是他并不满足于此,
 * 他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列
 *
 * 输出描述
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，
 * 序列间按照开始数字从小到大的顺序
 *
 *
 * @author Shawn
 * @date 2019/7/26
 */
public class Solution {

    @Test
    public void test() {
        // 功能测试
        int sum = 15;

        // 边界测试
//        int sum = 3;
        ArrayList<ArrayList<Integer>> results = FindContinuousSequence(sum);
        System.out.println(Arrays.toString(results.toArray()));
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if(sum < 3) {
            return results;
        }
        int num = (int)(Math.ceil(Math.sqrt(sum))) + 1;
        for(int i = num; i > 1; i--) {
            int big = sum -(i-1) * i /2;
            int temp = big % i;
            if(big > 0 && temp == 0) {
                ArrayList<Integer> result = new ArrayList<>();
                int x = big / i;
                for(int j=0; j < i; j++) {
                    result.add(x++);
                }
                results.add(result);
            }

        }
        return  results;
    }
}
