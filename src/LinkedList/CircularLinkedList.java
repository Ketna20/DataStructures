package LinkedList;

public class CircularLinkedList {

    public static void main(String[] args) {

    }

    //insertion in empty circular linked list
    public static ListNode insertInEmptyCircularList(ListNode last, int newData) {
        if(last != null) {
            return last;
        }
        ListNode newNode = new ListNode(newData);
        newNode.next = newNode;
        last = newNode;
        return last;
    }

}
