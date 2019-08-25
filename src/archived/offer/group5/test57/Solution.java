package archived.offer.group5.test57;

import org.junit.Test;

import java.util.*;

/**
 * 删除链表中重复的结点
 *
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，
 * 请删除该链表中重复的结点，重复的结点不保留，
 * 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * 思路：两个map实现
 *
 * @author Shawn
 * @date 2019/8/5
 */
public class Solution {

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        //ListNode node1 = null;
        ListNode result = deleteDuplication(node1);
        while (null != result) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    public ListNode deleteDuplication(ListNode pHead) {
        if(null == pHead) {
            return null;
        }
        ListNode p = pHead;
        LinkedHashMap<Integer, ListNode> linkMap = new LinkedHashMap<>();
        HashMap<Integer, ListNode> map = new HashMap<>();

        while (null != p) {
            int val = p.val;
            if(!map.containsKey(val)) {
                map.put(val, p);
                linkMap.put(val, p);
            } else {
                if(linkMap.containsKey(val)) {
                    linkMap.remove(val);
                }
            }
            p = p.next;
        }
        ListNode node = new ListNode(0);
        pHead = node;
        p = pHead;
        for(Integer key: linkMap.keySet()) {
            p.next = linkMap.get(key);
            p = p.next;
        }
        p.next = null;
        return pHead.next;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
