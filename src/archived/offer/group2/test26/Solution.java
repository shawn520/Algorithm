package archived.offer.group2.test26;


import org.junit.Test;

import java.util.*;

/**
 * 复杂链表的复制
 * 定义一种复杂链表的结构，该链表有一个值value，有两个指针。
 * 一个next指针，指向下一个节点，一个random指针，随机指向一个节点。
 * 复制该链表，返回链表的头指针head。
 *
 * 第一步：创建节点，复制next指针。
 * 第二步：复制ramdom指针。复制ramdom指针时间复杂度平方级
 *
 * 方法一：空间换时间，对第二步复制random优化。
 * 用Map存储原node节点和复制node节点的对应关系。
 * 时间复杂度线性级别，空间复杂度线性级别。
 *
 * @author Shawn
 * @date 2019/7/17
 */
public class Solution {

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

    public RandomListNode Clone(RandomListNode pHead) {
        RandomListNode p = pHead;
        if(null == p) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>(100);
        RandomListNode head = new RandomListNode(p.label);
        RandomListNode q = head;
        map.put(p, q);
        // 第一步, next复制
        // 建立一个Map

        while (null != p.next) {
            RandomListNode node = new RandomListNode(p.next.label);
            q.next = node;
            map.put(p.next, node);
            p = p.next;
            q = q.next;

        }

        // random 复制
        p = pHead;
        q = head;
        while (null != p) {
            RandomListNode key = p.random;
            RandomListNode value = map.get(key);
            q.random = value;
            p = p.next;
            q = q.next;
        }
        return head;
    }
}


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

