package offer.group3.test21;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *
 * 思路：借助map数据结构来实现。
 *
 * 思路二：借助辅助栈模拟入栈出栈过程。（优）
 *
 * @author Shawn
 * @date 2019/7/8
 */

public class Solution {


    @Test
    public void test() {
        // 测试用例1
        /*int [] pushA = {1,2,3,4,5};
        int [] popA = {4,5,3,2,1};*/

        // 测试用例2
        int [] pushA = {1};
        int [] popA = {2};
        boolean result = IsPopOrder(pushA, popA);
        if(result) {
            System.out.println("可能");
        } else {
            System.out.println("不可能");
        }
    }

    public boolean IsPopOrder(int [] pushA,int [] popA) {

        if(pushA.length != popA.length) {
            return false;
        }

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i< pushA.length; i++) {
            map.put(pushA[i], i);
        }

        Stack<Integer> stack = new Stack<>();
        int lastIndex = -1;

        for(int i = 0; i < popA.length; i++) {
            int data = popA[i];
            if(map.containsKey(data)){
                int index = map.get(data);
                if(index < lastIndex) {
                    if(stack.peek() == popA[i]) {
                        stack.pop();
                        lastIndex = index;
                        continue;
                    } else {
                        return false;
                    }

                } else {
                    for(int j = lastIndex + 1; j <= index; j++) {
                        stack.push(pushA[j]);
                    }
                    stack.pop();
                }
                lastIndex = index;

            } else {
                return false;
            }

        }
        return true;

    }
}
