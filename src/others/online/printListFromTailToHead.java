package others.online;

/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*    题目描述：
*    输入一个链表，从尾到头打印链表每个结点的值。
*    思路：
*    典型的先进后出，用栈来解决。
*
*/
import java.util.ArrayList;
import java.util.Stack;

class ListNode {
	int val;
	ListNode next =null;
	ListNode(int val){
		this.val = val;
	}
}

public class printListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<ListNode> stack = new Stack<>();
        ListNode current = listNode;
        while(current != null){
        	stack.push(current);
        	current = current.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        
        while(!stack.isEmpty()){
        	current = stack.pop();
        	list.add(current.val);
        }
        return list;
    }
}