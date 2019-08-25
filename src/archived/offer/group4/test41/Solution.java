package archived.offer.group4.test41;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * 题目描述：一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 *
 * num1,num2分别为长度为1的数组。传出参数
 * 将num1[0],num2[0]设置为返回结果
 *
 * 思路：用两个set来实现，第一个set判断是否存在，第二个set记录出现一次的数字
 * @author Shawn
 * @date 2019/7/24
 */
public class Solution {

    @Test
    public void test() {
        int [] array = {2,4,3,6,3,2,5,5};
        int [] num1 = new int[1];
        int [] num2 = new int[1];
        FindNumsAppearOnce(array, num1, num2);
    }

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        if(null == array || array.length == 0) {
            return ;
        }
        int length = array.length;
        LinkedHashSet<Integer> set = new LinkedHashSet<>(length);
        HashMap<Integer, Integer> map = new HashMap(length * 2);
        for(int i=0; i<length; i++) {
            int key = array[i];
            if(!map.containsKey(key)) {
                map.put(key, 1);
                set.add(key);
            } else {
                set.remove(key);
            }
        }
        Iterator<Integer> iterator = set.iterator();
        int [] num3 = new int[2];
        int i = 0;
        while (iterator.hasNext()) {
            num3[i++] = iterator.next();
        }
        num1[0] = num3[0];
        num2[0] = num3[1];

    }
}
