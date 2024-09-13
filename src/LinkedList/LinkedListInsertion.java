package LinkedList;

import ik.learn.LinkedList.SinglyLinkedList;

public class LinkedListInsertion {

    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        ListNode head = new ListNode(20);
        head.next = new ListNode(12);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(15);
        head.next.next.next.next = new ListNode(10);

        printLinkedList(head);

        ListNode insertedAtFront = insertAtFront(head, 32);
        System.out.println();
        System.out.println("insertedAtFront: ");
        printLinkedList(head);
        ListNode insertedAfter = insertAfter(head, 4, 7);
        System.out.println();
        System.out.println("insertedAfter: ");
        printLinkedList(head);
        ListNode insertedAtPosition = insertAtPosition(head, 5, 25);
        System.out.println();
        System.out.println("insertedAtPosition: ");
        printLinkedList(head);
        ListNode insertedAtEnd = insertAtEnd(head, 35);
        System.out.println();
        System.out.println("insertedAtEnd: ");
        printLinkedList(head);

    }

    public static void printLinkedList(ListNode head) {
        ListNode curr = head;
        System.out.print("[");
        while(curr != null) {
            System.out.print(curr.data + ", ");
            curr = curr.next;
        }
        System.out.print("]");
    }

    /**
     * insert a new node at the beginning of the given list.
     * @param head
     * @param data
     * @return
     */
    public static ListNode insertAtFront(ListNode head, int data) {
        // Create a new node with the given data
        ListNode newNode = new ListNode(data);
        // Make the next of the new node point to the
        // current head
        newNode.next = head;
        head = newNode;
        // Return the new node as the new head of the list
        return head;
    }

    /**
     * insert a new node after given node
     * @param head
     * @param data
     * @return
     */
    public static ListNode insertAfter(ListNode head, int key, int newData) {
        ListNode curr = head;

        // Iterate over Linked List to find the key
        while(curr != null) {
            if(curr.data == key) {
                break;
            }
            curr = curr.next;
        }
        // curr becomes null if key is not found in the list.
        if(curr == null) {
            return head;
        }

        ListNode newNode = new ListNode(newData);
        newNode.next = curr.next;
        curr.next = newNode;
        return head;
    }

    /**
     * insert the new node at the specified position in the list
     * @param head
     * @param position
     * @param newData
     * @return
     */
    public static ListNode insertAtPosition(ListNode head, int position, int newData) {
        ListNode newNode = new ListNode(newData);
        // if the position is at the beginning of the list
        if(position == 1) {
           newNode.next = head;
           return newNode; // newNode is now head of the list
        }
        ListNode curr = head;
        // bring the pointer at prev node of the position
        for(int i=1; i<position-1 && curr != null; i++) {
            curr = curr.next;
        }
        // position is out of bound then curr becomes null
        if(curr == null) {
            System.out.println("Position is out of bound.");
        }

        newNode.next = curr.next;
        curr.next = newNode;
        return head;
    }

    /**
     * insert the new node at the end of the list
     * @param head
     * @param newData
     * @return
     */
    public static ListNode insertAtEnd(ListNode head, int newData) {
        ListNode newNode = new ListNode(newData);

        // if the list is empty
        if (head == null) {
            return newNode;
        }

        ListNode curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }

        curr.next = newNode;
        return head;
    }


}
