package leetcode75;

/**
 * LeetCode 2130. Maximum Twin Sum of a Linked List
 * In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
 *
 * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
 * The twin sum is defined as the sum of a node and its twin.
 *
 * Given the head of a linked list with even length, return the maximum twin sum of the linked list.
 * Example 1:
 * Input: head = [5,4,2,1]
 * Output: 6
 * Explanation:
 * Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
 * There are no other nodes with twins in the linked list.
 * Thus, the maximum twin sum of the linked list is 6.
 *
 * Example 2:
 * Input: head = [4,2,2,3]
 * Output: 7
 * Explanation:
 * The nodes with twins present in this linked list are:
 * - Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
 * - Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
 * Thus, the maximum twin sum of the linked list is max(7, 4) = 7.
 */
public class MaxTwinSumLinkedList {

    public static void main(String[] args) {

    }

    public static int maxTwinSum(ListNode head) {
        if(head == null) {
            return 0;
        }
        if(head.next == null) {
            return head.val;
        }
        // cut list in half
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse the second half list
        ListNode secondHalf = reverseList(slow);
        // compare the sum from both half traversing from each end
        int maxSum = 0;
        while(head != null && secondHalf != null) {
            int twinSum = head.val + secondHalf.val;
            if(twinSum > maxSum) {
                maxSum = twinSum;
            }
            head = head.next;
            secondHalf = secondHalf.next;
        }
        return maxSum;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
