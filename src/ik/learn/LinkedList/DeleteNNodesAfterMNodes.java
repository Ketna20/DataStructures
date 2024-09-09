package ik.learn.LinkedList;
/*
 * ketnakhalasi created on 8/2/22
 * */

public class DeleteNNodesAfterMNodes {
    public static void main(String[] args) {
        SinglyListNode head = new SinglyListNode(1);
        head.next = new SinglyListNode(2);
        head.next.next = new SinglyListNode(3);
        head.next.next.next = new SinglyListNode(4);
        head.next.next.next.next = new SinglyListNode(5);
        head.next.next.next.next.next = new SinglyListNode(6);

        int afterNodeCount = 2;
        int deleteNodeCount = 3;

        SinglyListNode newList = deleteNNodesAfterMNodes(head, afterNodeCount, deleteNodeCount);

    // Print the modified linked list: 1, 2, 6
        while (newList != null) {
            System.out.print(newList.value + " ");
            newList = newList.next;
        }
    }

    public static SinglyListNode deleteNNodesAfterMNodes(SinglyListNode head, int afterNodeCount, int deleteNodeCount) {
        if (head == null || afterNodeCount <= 0 || deleteNodeCount <= 0) {
            return head; // Handle empty list, invalid `afterNodeCount`, or invalid `deleteNodeCount`
        }

        SinglyListNode current = head;
        SinglyListNode prev = null;

        while (current != null) {
            // Skip M nodes
            for (int i = 0; i < afterNodeCount && current != null; i++) {
                prev = current;
                current = current.next;
            }

            // If reached end of list, return the head
            if (current == null) {
                return head;
            }

            // Delete N nodes (handling potential end-of-list case)
            for (int j = 0; j < deleteNodeCount && current != null; j++) {
                current = current.next;
            }

            // If prev exists, connect it to the node after the deleted nodes
            if (prev != null) {
                prev.next = current;
            } else {
                // Handle deleting at the head of the list
                head = current;
            }
        }

        return head;
    }

}
