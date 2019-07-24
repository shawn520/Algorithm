package offer.group0.test5;

import java.util.Stack;

/**
 * 用两个栈实现一个队列
 * 分析：栈和队列是两种不同的数据结构，栈是LIFO后进先出，队列则是FIFO，先进先出。
 * 思路：a栈入队列，b栈出队列。
 * 入队：a栈正常入栈。
 * 出队：首先判断两个栈是否为空，为空提示队列为空。
 * 如果b栈为空，则将a栈的元素全部push到b栈。如果不为空，则继续往下执行。
 * b栈pop出队列。
 *
 * @author Shawn
 * @date 2019/7/4
 */


public class Solution2 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }

        }
        return stack2.pop();
    }
}
