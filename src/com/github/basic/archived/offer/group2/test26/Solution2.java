package com.github.basic.archived.offer.group2.test26;

import org.junit.Test;

/**
 * 复杂链表的复制的思路2
 * @author Shawn
 * @date 2019/7/17
 */

public class Solution2 {

    @Test
    public void test() {
        RandomListNode head = new RandomListNode(3);
        RandomListNode node1 = new RandomListNode(5);
        RandomListNode node2 = new RandomListNode(7);
        RandomListNode node3 = new RandomListNode(4);
        RandomListNode node4 = new RandomListNode(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        head.random = node2;
        node1.random = node3;
        node2.random = node4;
        node3.random = node1;
        node4.random = node2;

        RandomListNode randomListNode = Clone(head);
        System.out.println(randomListNode);

    }
    public RandomListNode Clone(RandomListNode pHead)
    {
        return method2(pHead);
    }

    public RandomListNode method2(RandomListNode pHead) {

        RandomListNode head = null;
        if(null != pHead) {
            // step1:复制next
            RandomListNode p = pHead;
            RandomListNode afterCopyNext = copyNext(p);

            // step2: 复制random
            RandomListNode afterCopyRandom = copyRandom(afterCopyNext);

            // step3: devide分解
            head = devide(afterCopyRandom);
        }
        return head;

    }

    public RandomListNode copyNext(RandomListNode p) {
        RandomListNode head = p;
        while (null != p) {
            RandomListNode node = new RandomListNode(p.label);
            node.next = p.next;
            p.next = node;
            p = p.next.next;
        }
        return head;
    }

    public RandomListNode copyRandom(RandomListNode node) {
        RandomListNode head = node;
        RandomListNode p = node;
        RandomListNode q = null;
        while (null != p) {
            q = p.next;
            q.random = p.random.next;
            p = q.next;
        }
        return head;
    }

    public RandomListNode devide(RandomListNode node) {

        RandomListNode q = node.next;
        RandomListNode head = q;
        while (null != q.next) {
            q.next = q.next.next;
            q = q.next;
        }
        return  head;
    }
}
