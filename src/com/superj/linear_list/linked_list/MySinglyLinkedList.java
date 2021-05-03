package com.superj.linear_list.linked_list;


/**
 * 单链表
 */
public class MySinglyLinkedList {

    //头结点指针
    private Node head;
    //尾结点指针
    private Node last;
    //链表实际长度
    private int size;

    //链表结点
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    /**
     * 插入
     * @param data 元素
     * @param index 下标
     */
    public void insert(int data,int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表结点范围！");
        }
        Node insertNode = new Node(data);
        //空链表
        if (size == 0) {
            head = insertNode;
            last = insertNode;
        } else if (index == 0) {
            //插入头部
            insertNode.next = head;
            head = insertNode;
        } else if (index == size) {
            //插入尾部
            last.next = insertNode;
            last = insertNode;
        } else {
            //插入中间
            Node prevNode = get(index - 1);
            insertNode.next = prevNode.next;
            prevNode.next = insertNode;
        }
        size++;
    }

    /**
     * 删除
     * @param index 下标
     * @return 删除的元素
     */
    public Node remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表结点范围！");
        }
        Node removedNode = null;
        if (index == 0) {
            //删除头结点
            removedNode = head;
            head = head.next;
        } else if (index == size - 1) {
            //删除尾结点
            Node prevNode = get(index - 1);
            removedNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        } else {
            //删除中间结点
            Node prevNode = get(index - 1);
            Node nextNode = prevNode.next.next;
            removedNode = prevNode.next;
            prevNode.next = nextNode;
        }
        size--;
        return removedNode;
    }

    //查找
    private Node get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表结点范围！");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 输出链表
     */
    public void output() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        //初始化
        MySinglyLinkedList msll = new MySinglyLinkedList();
        msll.insert(2,0);
        msll.insert(2,1);
        msll.insert(3,2);
        msll.insert(3,1);
        msll.remove(0);
        msll.output();
        //查找和更新

        //插入
        //1.尾部插入
        //2.中间插入
        //3.超范围插入
        //删除
    }
}
