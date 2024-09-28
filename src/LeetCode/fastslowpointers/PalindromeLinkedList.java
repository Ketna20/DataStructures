package LeetCode.fastslowpointers;

import leetcode75.ListNode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        //cut list in half
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // reverse the second half
        ListNode secondHalf = reverseList(slow);
        // compare first and secondHalf for palindrom check
        while(head != null && secondHalf != null) {
            if(head.val != secondHalf.val) {
                return false;
            }
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode t = curr.next;
            curr.next = prev;
            prev = curr;
            curr = t;
        }
        return prev;
    }
}
