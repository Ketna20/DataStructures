package LinkedList;


public class MyLinkedList {
    ListNode head;



    public static void main(String[] args) {
        MyLinkedList list1 = new MyLinkedList();
        MyLinkedList list2 = new MyLinkedList();

        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(2);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(2);

        list1.head = head;
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;

        System.out.println("List1");
        list1.printList();
        int middle = list1.getMiddle(list1.head);
        System.out.println("middle: " + middle);

        int TwoCounts = list1.countOccurance(2);
        System.out.println("TwoCounts: " + TwoCounts);




        //int thirdFromEnd = list1.printNthFromEnd(list1.head, 3);
       // System.out.println("3rd from last: " + thirdFromEnd);
        //list1.deleteNodeAtPosition(3);

       //System.out.println("deleted node 3");
       // list1.printList();

//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//
//        list2.head = n1;
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//
//        System.out.println("List2");
//        list2.printList();
//
//        boolean sameLists = compareLists(list1.head, list2.head);
//        System.out.println("same Lists: " + sameLists);
    }

    public void insert(int val) {
        ListNode newListNode = new ListNode(val);
        if(this.head == null) {
            this.head = newListNode;
            return;
        }
        while(head.next != null) {
            head = head.next;
        }
        head.next = newListNode;
        return;
    }

    /**
     *
     * @param listNode
     * @return count of nodes from the listNode till end.
     */

    public int countNodes(ListNode listNode) {
        int count = 1;
        ListNode temp = listNode;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }


    /**
     *
     * @param head
     * @return number of nodes in the loop
     */
    public int countNodesInLoop (ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
            {
                return countNodes(slow);
            }
        }
        return 0;
    }

    /**
     *
     * @param head1
     * @param head2
     * @return true if both lists have same length and same data
     */

    // compare two linked lists
    public static boolean compareLists(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return true;
        } else if (head1 == null || head2 == null) {
            return false;
        }

        if (head1.data == head2.data) {
            return compareLists(head1.next, head2.next);
        } else {
            return false;
        }
    }

    /** * * * * * * * * * * * * * * * * * * * * * * *
     * merge two linked lists * * * * * * * * * * * *
     * * * * * * * * * * * * * * * * * * * * * * *  */
    public static ListNode mergeLists(ListNode head1, ListNode head2){
        if (head1 == null && head2 == null)
            return null;
        else if(head1 == null)
            return head2;
        else if(head2 == null)
            return head1;

        if(head1.data <= head2.data) {
            head1.next = mergeLists(head1.next, head2);
        } else {
            ListNode temp = head2;
            head2 = head2.next;
            temp.next = head1;
            head1 = temp;
            head1.next = mergeLists(head1.next, head2);
        }
        return head1;
    }

    /** * * * * * * * * * * * * * * * * * * * * * * *
     * prints contents of linked list to the output *
     * * * * * * * * * * * * * * * * * * * * * * * */
    public void printList() {
        ListNode n = head;
        while(n != null) {
            System.out.println(n.data + " ");
            n = n.next;
        }
    }




    /*
    Given a singly linked list with N nodes and a number X. The task
    is to find the node at the given index (X)(1 based index) of
    linked list.

    Example:
    Input:
    2
    6 5
    1 2 3 4 657 76
    10 2
    8 7 10 8 6 1 20 91 21 2

    Output:
    657
    7
     */

    public static int getNth(ListNode listNode, int ind)
    {
        for (int i=1; i < ind; i++) {
            listNode = listNode.next;
        }
        return listNode.data;
    }

    /* Function to find middle element a linked list
     For example, if given linked list is 1->2->3->4->5 then output
     should be 3.
    If there are even nodes, then there would be two middle nodes,
    we need to print second middle element. For example, if given
    linked list is 1->2->3->4->5->6 then output should be 4.

    Hint:  Find middle element using two pointer technique.
    Take two pointers i.e. fast and slow. Start both pointers
    from head. Fast pointer will move double the slow pointer
    each time till it reaches end. As soon as fast pointer reaches
    end , our slow pointer will be on the middle element.
      In while loop Fast.next != null handles the odd number of
      elements.

     */
    int getMiddle(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.data;
    }

    // Reverse a Linked List
    ListNode reverseList(ListNode head)
    {
        if (head.next == null)
            return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public void deleteNodeAtPosition (int position) {
        ListNode temp = head;

        if (position == 0) {
            head = temp.next;
            return;
        }

       for (int i=0; temp != null && i<position-1; i++) {
           temp = temp.next;
       }
       if (temp == null || temp.next == null) {
           return;
       }

       ListNode next = temp.next.next;
       temp.next = next;

    }

    /****
     * get Nth node from last of a linked list
     */
    public int printNthFromEnd (ListNode head, int n) {
        int data = 0, len = 0;
        if (head == null)
            return data;

        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            len++;
        }
        System.out.println("len : " + len);
        if (len < n) {
            return data;
        }

        temp = head;
        for (int i=1; i < len - n + 1; i++) {
            temp =temp.next;
        }

        return temp.data;
    }

    /*
    counts the number of times a given int occurs in a Linked List
     */
    public int countOccurance (int search_for) {
        ListNode current = head;
        int count =0;
        while (current != null) {
            if (current.data == search_for)
                count++;
            current = current.next;
        }
        return count;
    }

}
