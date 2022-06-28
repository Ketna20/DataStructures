package ik.learn.queue;

import ik.learn.LinkedList.Node;

/*
 * ketnakhalasi created on 6/25/22
 * */
// Double-Ended Queue
public class DequeImpl {
    int size;
    Node head;
    Node tail;

    public DequeImpl(int k){
        head = tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertFirst(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void insertLast(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public int size() {
        return size;
    }

}
