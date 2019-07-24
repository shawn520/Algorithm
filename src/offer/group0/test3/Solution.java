package offer.group0.test3;

/**
 * 描述
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 * 思路: 实现先进后出
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        //return useStack(listNode);
        //return useTwoArrayList(listNode);
        return useRecursive(listNode);
    }


    //方法一:使用栈的特性
    public ArrayList<Integer> useStack(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (null != listNode) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }


    //方法二:两个队列实现先进后出
    public ArrayList<Integer> useTwoArrayList(ListNode listNode) {
        List<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> newArray = new ArrayList<>();
        while(null != listNode) {
            arrayList.add(listNode.val);
            listNode = listNode.next;
        }
        for (int i = arrayList.size()-1; i>=0; i--) {
            newArray.add(arrayList.get(i));
        }

        return newArray;
    }

    //方法三:使用递归的方法
    ArrayList<Integer> arrayList = new ArrayList<>();
    public ArrayList<Integer> useRecursive(ListNode listNode) {
        if(null != listNode) {
            this.useRecursive(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}


class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}