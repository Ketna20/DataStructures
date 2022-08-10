package ik.learn.LinkedList;
/*
 * ketnakhalasi created on 7/31/22
 * */

public class MyLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode head;
    public ListNode tail;
    public int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
        // return this.head == null;
    }

    public ListNode findNodeByIndex(int index) {
        if( index < 0 || index > this.size || this.isEmpty() ) {
            return null;
        }

        ListNode currentNode = this.head;
        for( int i = 0; i < index && currentNode != null; i++ ) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }

    public int get(int index) {
        if( this.isEmpty() ) {
            return -1;
        }

        ListNode searchedNode = this.findNodeByIndex( index );
        return ( searchedNode != null ? searchedNode.val : -1 );
    }

    public void addAtHead(int val) {
        this.head = new ListNode(val, this.head);

        if(tail == null) {
            this.tail = this.head;
        }
        this.size++;
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        if(this.isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = this.tail.next;
        }
        this.size++;
    }

    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size)
            return;

        if(index == 0) {
            this.addAtHead(val);
            return;
        }
        if(index == this.size) {
            this.addAtTail(val);
            return;
        }
        ListNode node = this.findNodeByIndex(index-1);
        ListNode newNode = new ListNode(val, node.next);
        node.next = newNode;
        this.size++;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index > this.size-1 || this.isEmpty()){
            return;
        }

        if(index == 0){
            this.head = this.head.next;
        } else {
            ListNode node = this.findNodeByIndex(index-1);
            if(node.next == this.tail) {
                this.tail = node;
                this.tail.next = null;
            } else {
                node.next = node.next.next;
            }
        }
        this.size--;
    }
}
