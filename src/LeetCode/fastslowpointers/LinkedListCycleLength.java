package LeetCode.fastslowpointers;

import leetcode75.ListNode;

public class LinkedListCycleLength {

    public int getLoopLength(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return countNodes(slow);
        }
        return 0;
    }

    public int countNodes(ListNode node) {
        int count = 1;
        ListNode t = node;
        while(t.next != node) {
            count++;
            t = t.next;
        }
        return count;
    }
}
