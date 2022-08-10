package ik.learn.LinkedList;
/*
 * ketnakhalasi created on 6/21/22
 * */

public class SinglyListNode {
    int value;
    SinglyListNode next;

    public SinglyListNode(int x) {
        value = x;
        next = null;
    }

    public SinglyListNode(int x, SinglyListNode next) {
        value = x;
        next = next;
    }
}
