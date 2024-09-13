package LinkedList;

/**
 * LeetCode: 234: Palindrome Linked List
 * Approach:
 * find the mid of the linked list
 * reverse the linked list from second half
 * compare the values of both half lists, if equal - return true.
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //Reverse the second half list
        ListNode secondHalf = reverseList(slow.next);
//        compare first and second half
        while (head != null && secondHalf != null) {
            if(head.data != secondHalf.data) {
                return false;
            }
            head = head.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
