package LinkedList;
/*
 * ketnakhalasi created on 8/17/22
 * */

public class IntersectionOf2LinkedList {
    /*
     *  Intersection of Two Linked List
     *  ListA = 4->1->8->4->5
     *  ListB = 5->6->1->8->4->5
     *  intersection is at 8 , not at 1.
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a=headA,b=headB;
        while(a!=b){
            if(a==null)
                a=headB;
            else
                a=a.next;

            if(b==null)
                b=headA;
            else
                b=b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        MyLinkedList list1 = new MyLinkedList();
        MyLinkedList list2 = new MyLinkedList();

        list1.insert(4);
        list1.insert(1);
        list1.insert(8);
        list1.insert(4);
        list1.insert(5);

        list2.insert(5);
        list2.insert(6);
        list2.insert(1);
        list2.insert(8);
        list2.insert(4);
        list2.insert(5);
        ListNode headA = list1.head;
        ListNode headB = list2.head;
//        ListNode intersectionNode = getIntersectionNode(headA, headB);
    }

}
