package ik.learn.LinkedList;
/*
 * ketnakhalasi created on 7/31/22
 * */

public class MyLinkedListMain {


//    ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
//            [[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7); //7
        myLinkedList.addAtHead(2); // 2->7
        myLinkedList.addAtHead(1); // 1->2->7
        MyLinkedList.ListNode curr = myLinkedList.head;
        while(curr != null){
            System.out.println("curr.val: " + curr.val);
            curr = curr.next;
        }
        myLinkedList.addAtIndex(3, 0); // will not add
        MyLinkedList.ListNode curr1 = myLinkedList.head;
        while(curr1 != null){
            System.out.println("curr1.val: " + curr1.val);
            curr1 = curr1.next;
        }
        myLinkedList.deleteAtIndex(2);  // deletes 7 -so list is 1->2
        myLinkedList.addAtHead(6); // 6->1->2
        myLinkedList.addAtTail(4); //6->1->2->4
        myLinkedList.get(4); // no index 4 - return -1
        myLinkedList.addAtHead(4); // 4->6->1->2->4
        myLinkedList.addAtIndex(5, 0); // will not add
        myLinkedList.addAtHead(6); // 6->4->6->1->2->4

//        myLinkedList.addAtHead(1);
//        System.out.println("My Linked List: " + myLinkedList.head);
//        myLinkedList.addAtTail(3);
//        System.out.println("My Linked List: " + myLinkedList.tail);
//        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
//        MyLinkedList.ListNode curr = myLinkedList.head;
//        while(curr != null){
//            System.out.println("curr.val: " + curr.val);
//            curr = curr.next;
//        }
//        System.out.println("myLinkedList.get(1): " + myLinkedList.get(1));              // return 2
//        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
//
//        MyLinkedList.ListNode curr1 = myLinkedList.head;
//        while(curr1 != null){
//            System.out.println("curr1.val: " + curr1.val);
//            curr1 = curr1.next;
//        }
//        System.out.println("myLinkedList.get(1): " + myLinkedList.get(1));              // return 3
    }
}
