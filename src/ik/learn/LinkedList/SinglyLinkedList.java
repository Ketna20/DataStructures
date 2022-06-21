package ik.learn.LinkedList;
/*
 * ketnakhalasi created on 6/21/22
 * */

public class SinglyLinkedList {
    SinglyListNode head;

    public void addNode(int x) {
        SinglyListNode newNode = new SinglyListNode(x);
        newNode.next = head;
        head = newNode;
    }

    public SinglyListNode getHead() {
        return head;
    }

}
