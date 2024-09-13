package leetcode75;

/**
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
 *
 * The first node is considered odd, and the second node is even, and so on.
 *
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 *
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 * Example 2:
 * Input: head = [2,1,3,5,6,4,7]
 * Output: [2,3,6,7,1,5,4]
 */
public class OddEvenLinkedList {
    public static void main(String[] args) {

    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // count # of nodes
        ListNode curr = head;
        int count = 1;
        while (curr.next != null) {
            count++;
            curr = curr.next;
        }
        // connect the odd indices nodes and even indices nodes
        ListNode sentinel = null;
        ListNode prev = head;
        ListNode temp = head.next;
        ListNode head2 = head.next;
         while(prev.next != null) {
             prev.next = temp.next;
             sentinel = prev;
             prev = temp;
             temp = temp.next;
         }

         // connect the even indices after the odds indices
        if(count %2 == 0) {
            sentinel.next = head2;
        } else {
            prev.next = head2;
        }


        return head;
    }
}
