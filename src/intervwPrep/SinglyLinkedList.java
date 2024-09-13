package intervwPrep;
/*
 * ketnakhalasi created on 8/18/21
 * */

import java.util.HashSet;
import java.util.Set;

public class SinglyLinkedList {
    private final class Node {
        private int data;
        private Node next;

        @Override
        public String toString() {
            return "ListNode{" +
                    "data=" + data +
                    '}';
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public boolean isEmpty() {
        return head == null;
    }

    //insert a node at the start of linked list
    public void insertFirst(int data) {
        //create a new node
        Node newNode = new Node();
        newNode.data = data;
        // link the new node to the list as the first node
        // newNode points to the current head
        // (which can be null if the linked list is empty)
        newNode.next = head;
        // new node becomes head
        head = newNode;

        // if this is the first node then it is the tail as well
        if(tail == null) {
            tail = newNode;
        }
        //set the new size
        size++;
    }

    //O(n) Solution (time & space)
    public void removeDuplicates1(){
        Set<Integer> dataSet = new HashSet<>();

        Node currentNode = head;
        Node prevNode = null;
        while(currentNode != null) {
            if(dataSet.contains(currentNode.data)) {
                prevNode.next = currentNode.next;

                if(currentNode == tail) {
                    tail = prevNode;
                }
                size--;
            } else {
                dataSet.add(currentNode.data);
                prevNode = currentNode;
            }
            currentNode = currentNode.next;
        }
    }

    //O(n^2) Solution time, O(1) space
    public void removeDuplicates2() {
        Node currentNode = head;
        while (currentNode != null) {
            Node runnerNode = currentNode;

            while(runnerNode.next != null) {
                if(runnerNode.next.data == currentNode.data) {
                    if(runnerNode.next == tail) {
                        tail = runnerNode;
                    }

                    runnerNode.next = runnerNode.next.next;
                    size--;
                } else {
                    runnerNode = runnerNode.next;
                }
            }
            currentNode = currentNode.next;
        }
    }

    public void print() {
        System.out.println("\nHead (" + head + ") -----> last ( " + tail + "):");
        Node currentNode = head;
        while(currentNode != null) {
            System.out.println(currentNode);
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public int size() {
        return size;
    }
}
