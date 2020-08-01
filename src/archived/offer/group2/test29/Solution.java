package archived.offer.group2.test29;

import org.junit.Test;

import java.util.HashMap;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，
 * 因此输出2。如果不存在则输出0。
 *
 * 思路：空间换时间，用一个长度为数组长度的map存储。
 * map的key存储数组元素的值, value存储元素出现的次数。
 *
 * 时间复杂度：O(n)
 * 空间复杂度: O(n)
 *
 * @author Shawn
 * @date 2019/7/19
 */
public class Solution {

    @Test
    public void test() {
        // 功能测试
        int [] array = {1,2,3,2,2,2,5,4,2};
        // 边界测试
//        int [] a_array = {1};

        int value = MoreThanHalfNum_Solution(array);
        System.out.println(value);
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        int length = array.length;
        int half = length/2;
        HashMap<Integer, Integer> map = new HashMap<>(length);

        for(int i=0; i<array.length; i++) {
            int count = 0;
            if(!map.containsKey(array[i])) {
                map.put(array[i], count);
            } else {
                count = map.get(array[i]);
                count++;
            }
            if(count >= half) {
                return array[i];
            } else {
                map.replace(array[i], count);
            }
        }
        return 0;
    }
}
