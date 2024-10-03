package LeetCode.LinkedList;

import leetcode75.ListNode;

public class InsertionSortList_147 {

    public ListNode insertSortList(ListNode head) {
        ListNode dummy = new ListNode(1000);
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            ListNode temp = dummy;

            while(temp.next != null && temp.next.val < curr.val) {
                temp = temp.next;
            }
            curr.next = temp.next;
            temp.next = curr;
            curr = next;

        }
        return dummy.next;
    }
}
