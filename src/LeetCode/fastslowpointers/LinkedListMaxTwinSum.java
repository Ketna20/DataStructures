package LeetCode.fastslowpointers;

import leetcode75.ListNode;

public class LinkedListMaxTwinSum {

    public int maxTwinSum(ListNode head) {
        if(head == null || head.next == null) return 0;

        ListNode slow = head;
        ListNode fast = head;
        //cut list in half
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse the second half list
        ListNode secondHalf = reverseList(slow);
        int maxTwinSum = 0;
        while(head != null && secondHalf != null) {
            int twinSum = head.val + secondHalf.val;
            if(maxTwinSum < twinSum) {
                maxTwinSum = twinSum;
            }
            head = head.next;
            secondHalf = secondHalf.next;

        }

        return maxTwinSum;
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
