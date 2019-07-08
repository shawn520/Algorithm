package offer.test20;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 思路：借助一个辅助栈记录栈中最小值的记录，如果push的值小于等于min则同时push到min_stack
 * pop时，如果等于mins_tack栈顶的值则同时pop min_stack栈中的值。
 * @author Shawn
 * @date 2019/6/29
 */
import java.util.Stack;

public class Solution {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min_stack = new Stack<>();


    public void push(int node) {
        if(stack.isEmpty()) {

            min_stack.push(node);
        } else {
            if(node <= min_stack.peek()) {
                min_stack.push(node);
            }
        }
        stack.push(node);

    }

    public void pop() {
        if(stack.peek().equals(min_stack.peek())) {
            min_stack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();

    }

    public int min() {
        return min_stack.peek();
    }
}
