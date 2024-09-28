package LeetCode.fastslowpointers;

import leetcode75.ListNode;

public class LisnkedListCycleBeginsNode {

    public ListNode getCycleBeginNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return slow;
        }
        return null;
    }
}
