package offer.group6.test64;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 数据流中的中位数
 * 题目描述
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 *
 * 分析：
 *
 * @author Shawn
 * @date 2019/8/12
 */
public class Solution {
    List<Integer> array = new ArrayList<>();

    public void Insert(Integer num) {
        array.add(num);
        Collections.sort(array);
    }

    public Double GetMedian() {
        int length = array.size();
        if(0 == length){
            return null;
        }
        int index = length /2;
        if(length % 2 == 0) {
            int left = index - 1;
            double result = 0.5 * (array.get(left) + array.get(index));
            return result;
        } else {

            return array.get(index).doubleValue();
        }
    }
}
