package ik.learn.LinkedList;
/*
 * ketnakhalasi created on 6/25/22
 * */

public class DoublyLinkedList {
    Node head;
    Node tail;


    public void insertFirst(int value) {
       Node newNode = new Node(value);
       if(head == null) {
           head = tail = newNode;
       } else {
           newNode.next = head;
           head = newNode;
       }

    }

    public void insertLast(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

    }

    public Node removeFirst() {
        Node nodeToRemove = head;
        head = head.next;
        return nodeToRemove;
    }

    public Node removeLast() {
        Node nodeToRemove = tail;
        tail = tail.prev;
        return nodeToRemove;
    }

    public Node first() {
        return head;
    }

    public Node last() {
        return tail;
    }




}
