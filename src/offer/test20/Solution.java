package offer.test20;

/**
 * @author Shawn
 * @date 2019/6/29
 */
import java.util.Stack;

public class Solution {

    Stack<Integer> stack = new Stack<>();


    public void push(int node) {
        if(stack.empty()) {
            stack.add(node);
        }else {

            Stack<Integer> temp = new Stack<>();
            while(null != stack) {
                while (stack.peek() < node) {
                    temp.push(stack.pop());
                }
                stack.push(node);
                while (null != temp) {
                    stack.push(temp.pop());
                }
            }
        }

    }

    public void pop() {

    }

    public int top() {
        return stack.peek();

    }

    public int min() {
        return stack.peek();

    }
}
