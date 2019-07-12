package offer.group3.test22;

import org.junit.Test;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是第一个重复的数字2。
 *
 * 思路：开辟一个空间为n的数组，默认值全部为-1；
 * 如果numbers第i个值a不等于-1的话，则a插入数组对应的index a.
 * 如果相等则说明数据重复，返回true
 *
 * 遍历一遍之后，如果还没返回则说明没有重复数字，返回false.
 *
 * @author Shawn
 * @date 2019/7/10
 */
public class Solution {

    @Test
    public void test() {
        //功能测试
        int numbers[] = {2,3,1,0,2,5,3};
        int length = 7;
        int [] duplication = new int[1];
        //边界测试

        //负面测试

        Boolean result = duplicate(numbers, length, duplication);
        System.out.println("result = " + result + ", data = " + duplication[0]);

    }

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        int [] array = new int[length];
        for(int i=0; i<length; i++) {
            array[i] = -1;
        }

        for(int i = 0; i < length; i++) {
            int data = numbers[i];
            if(array[data] != data) {
                array[data] = data;
            } else {
                duplication[0] = data;
                return true;
            }
        }
        return false;

    }
}
