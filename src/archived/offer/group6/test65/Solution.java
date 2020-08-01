package archived.offer.group6.test65;
import com.sun.jmx.remote.internal.ArrayQueue;
import java.util.ArrayList;
import java.util.List;

/**
 * 滑动窗口的最大值
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 *
 * 分析：
 * 用队列模拟滑动窗口
 *
 * @author Shawn
 * @date 2019/8/12
 */
public class Solution {

    /*@Test
    public void test() {
        int [] a_array = {2,3,4,2,6,2,5,1};
        int size = 3;
        ArrayList<Integer> result = maxInWindows(a_array, size);
        System.out.println(result.toString());
    }*/

    public ArrayList<Integer> maxInWindows(int [] num, int size) {

        ArrayList<Integer> result = new ArrayList<>();
        if(null == num || 0 == num.length || size > num.length || size == 0) {
            return result;
        }
        int length = num.length;
        List<Integer> queue = new ArrayQueue<>(size);
        for(int i = 0; i < size; i++) {
            queue.add(num[i]);
        }
        int temp = queue.stream().max(Integer::compareTo).get();
        result.add(temp);
        for(int i = size; i < length; i++) {
            queue.remove(0);
            queue.add(num[i]);
            temp = queue.stream().max(Integer::compareTo).get();
            result.add(temp);
        }
        return result;
    }
}
