package basic.java;

class Node{
    Node next = null;
    int val;
    public Node (int val){
        this.val = val;
    }
}

public class LinkList {
    Node head = null;

    /**
     * 向链表尾部添加元素
     * @param val
     */
    public void insert(int val) {
        Node newNode = new Node(val);
        if(null == head) {
            head = newNode;
            return ;
        }

        Node p = head;
        while (null != p.next) {
            p = p.next;
        }
        p.next = newNode;
    }

    /**
     * 向链表指定位置添加元素
     * @param index 位置的index
     * @param val 插入元素的值
     */
    public Boolean insert(int index, int val) {
        if(index < 0) {
            return false;
        }

        Node newNode = new Node(val);
        if(null == head && index == 0) {
            head = newNode;
            return true;
        }

        //获取链表的长度
        int length = 0;
        Node temp = head;
        while(null != temp.next) {
            temp = temp.next;
            length++;
        }

        // 插入位置不合法
        if(index > length + 1) {
            return false;
        }

        Node p = head;
        while (index > 0) {
            p = p.next;
        }
        newNode = p.next;
        p.next = newNode;
        return true;
    }
}
