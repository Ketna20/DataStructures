package intervwPrep;
/*
 * ketnakhalasi created on 8/18/21
 * */

public class SinglyLinkedList {
    private final class Node {
        private int data;
        private Node next;

        @Override
        public String toString() {
            return "Node{" +
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
}
