package ik.learn.LinkedList;
/*
 * ketnakhalasi created on 6/21/22
 * */

import java.util.HashMap;
import java.util.HashSet;

public class CycleDetection {

    public static boolean hasCycle(SinglyListNode head) {
        SinglyListNode fast = head;
        SinglyListNode slow = head;
        while(fast != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }

    //using Hashset
    public static boolean hasLoop(SinglyListNode head) {
        HashSet<SinglyListNode> hashSet = new HashSet();
        while(head != null) {
            if(hashSet.contains(head)) {
                return true;
            }
            hashSet.add(head);
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        SinglyLinkedList myList = new SinglyLinkedList();
        myList.addNode(20);
        myList.addNode(4);
        myList.addNode(15);
        myList.addNode(10);

        // create a loop
        myList.head.next.next.next.next = myList.head.next;

        SinglyListNode head = myList.getHead();
        System.out.println("head : " + head.value);
         if(hasCycle(head)) {
             System.out.println("This LinkedList has cycle");
         } else {
             System.out.println("This LinkedList has  no cycle");
         }
        if(hasLoop(head)) {
            System.out.println("This LinkedList has loop");
        } else {
            System.out.println("This LinkedList has  no loop");
        }
    }
}
