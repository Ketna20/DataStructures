package LinkedList;

import java.util.*;
import java.util.stream.Collectors;

public class LinkedList<AnyType> implements Iterable<AnyType> {
    private Node<AnyType> head;

    //Constructs an empty list
    public LinkedList(){
        head = null;
    }

    //Return True if the list is empty
    public boolean isEmpty(){
        return head == null;
    }

    //Insert a new node in beginning of list
    public void addFirst(AnyType item) {
        head =new Node<AnyType>(item, head);
    }

    //Returns first element in the list
    public AnyType getFirst() {
        if(head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    //Removes first element in the list
    public AnyType removeFirst(){
        AnyType temp = getFirst();
        head = head.next;
        return temp;
    }

    // Inserts a new node to the end of the list
    public void addLast(AnyType item) {
        if(head == null){
            addFirst(item);
        } else {
            Node<AnyType> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node<AnyType>(item, null);
        }
    }
    //Returns last element in the list
    public AnyType getLast() {
        if(head == null) {
            throw new NoSuchElementException();
        }
        Node<AnyType> temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        return temp.data;
    }

    //Removes all nodes from the list
    public void clear() {
        head = null;
    }

    // returns true if the list contains a specified element
    public boolean contains(AnyType x) {
        for(AnyType temp : this) {
            if (temp.equals(x))
                return true;
        }
        return false;
    }

    // Delete a ListNode -- given head of list and position to delete node
    public Node<AnyType> deleteNodeAtSpecificPosition(Node<AnyType> head, int position) {
        if (position == 0) {
            Node<AnyType> newHead = head.next;
            return newHead;
        }
        Node<AnyType> temp = head;
        for(int k=1; k<position; k++) {
            temp = temp.next;
        }
        Node<AnyType> newNext = temp.next.next;
        temp.next = newNext;
        return head;
    }

    //Reverse Print the Linked List
    public void printReverse(Node<AnyType> head) {
        if(head != null) {
            Stack<Node<AnyType>> stk = new Stack<Node<AnyType>>();
            Node<AnyType> temp = head;
            while (temp != null) {
                stk.push(temp);
                temp = temp.next;
            }

            while(stk.size() > 0) {
                System.out.println(stk.peek().data);
                stk.pop();
            }
        }
    }

    //Returns data at the specified position
    public AnyType get(int pos) {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }

        Node<AnyType> temp = head;
        for(int k=0; k<pos; k++){
            temp = temp.next;
        }
        if(temp == null) {
            throw new IndexOutOfBoundsException();
        }
        return temp.data;
    }


    public int getLength () {
        if (head == null) return 0;

        int count = 0;
        Node<AnyType> temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }

        return count;
    }

    public int getLengthRecursively(Node<AnyType> head) {
        if (head == null) {
            return 0;
        }
         return 1 + getLengthRecursively(head.next);
    }

    //Insert ListNode at specified position
    public Node<AnyType> insertAtSpecificPosition(Node<AnyType> head, AnyType data, int position) {
        if(head == null) {
            return new Node<AnyType>(data, null);
        }
        Node<AnyType> temp = head;
        for(int k=1; k<position; k++){
            temp = temp.next;
        }
        if(temp != null) {
            Node<AnyType> prev = temp.next;
            temp.next = new Node<AnyType>(data, prev);
        } else {
            temp.next = new Node<AnyType>(data, temp);
        }

        return head;
    }

    // Returns a string representation of the list
    public String toString(){
        StringBuffer result = new StringBuffer();
        for (Object x : this){
            result.append(x + " ");
        }
        return result.toString();
    }

    //Inserts a new node after a node containing a key
    public void insertAfter(AnyType key, AnyType toInsert) {
        Node<AnyType> temp = head;
        while (temp != null && !temp.data.equals(key)) {
            temp = temp.next;
        }
        if(temp != null) {
            temp.next = new Node<AnyType>(toInsert, temp.next);
        }
    }

    //Inserts a new node before a node containing a key
    public void insertBefore(AnyType key, AnyType toInsert) {
        if (head == null)
            return;
        if(head.data.equals(key)){
            addFirst(toInsert);
            return;
        }
        Node<AnyType> prev = null;
        Node<AnyType> curr = head;

        while (curr != null && !curr.data.equals(key)) {
            prev = curr;
            curr = curr.next;
        }
        //insert between curr and prev
        if(curr != null){
            prev.next = new Node<AnyType>(toInsert, curr);
        }
    }

    public Node<AnyType> insertAtTail(Node<AnyType> head, AnyType data) {
        Node<AnyType> newNode = new Node<AnyType>(data, null);
        if(head == null)
            return newNode;

        Node<AnyType> currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
        return head;
    }

    public Node<AnyType> insertAtHead(Node<AnyType> head, AnyType data) {
        Node<AnyType> newNode = new Node<AnyType>(data, head);
        if (head == null) return newNode;

        Node<AnyType> currHead = head;
        head = newNode;
        newNode.next = currHead;

        return newNode;

    }


    //Removes first occurrence of the specified element in the list
    public void remove(AnyType key) {
        if (head == null) {
            throw new RuntimeException("cannot delete");
        }

        if(head.data.equals(key)){
            head = head.next;
            return;
        }

        Node<AnyType> prev = null;
        Node<AnyType> curr = head;
        while (curr != null && !curr.data.equals(key)){
            prev = curr;
            curr = curr.next;
        }
        if(curr == null) {
            throw new RuntimeException("cannot delete");
        }
        //delete curr node
        prev.next = curr.next;
    }

    /* Returns a deep copy of the list
     * complexity : O(n^2)
     */
    public LinkedList<AnyType> copy1(){
        LinkedList<AnyType> twin = new LinkedList<AnyType>();
        Node<AnyType> temp = head;
        while (temp != null) {
            twin.addLast(temp.data);
            temp = temp.next;
        }
        return twin;
    }
    /* Returns a deep copy of the list
     * complexity : O(n)
     */
    public LinkedList<AnyType> copy2(){
        LinkedList<AnyType> twin = new LinkedList<AnyType>();
        Node<AnyType> temp = head;
        while(temp != null) {
            twin.addFirst(temp.data);
            temp = temp.next;
        }
        return twin.reverse();
    }

    /** Reverses The List
     * complexity : O(n)
     */
    public LinkedList<AnyType> reverse() {
        LinkedList<AnyType> list = new LinkedList<AnyType>();
        Node<AnyType> temp = head;
        while(temp != null) {
            list.addFirst(temp.data);
            temp = temp.next;
        }
        return list;
    }

    /** Returns a deep copy of immutable list
     *  It uses a tail reference
     *  Complexity: O(n)
     */
    public LinkedList<AnyType> copy3(){
        LinkedList<AnyType> twin = new LinkedList<AnyType>();
        Node<AnyType> temp = head;
        if(head == null)
            return null;
        twin.head = new Node<AnyType>(head.data, null);
        Node<AnyType> tempTwin = twin.head;
        while(temp.next != null) {
            temp = temp.next;
            tempTwin.next = new Node<AnyType>(temp.data, null);
            tempTwin = tempTwin.next;
        }
        return twin;
    }

    /**
     * // we only check in while condition for fast, fast will reach
     *         // first to end of list if no cycle in the list, no need to loop
     *         // through fro slow to reach to end of list.
     *         //this also works if the list is empty, or if has one node.
     *         // so no need to check extra line of code for if head == null
     */
    public boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // make sure to check for this after moving the pointers,
            // coz both are starting at head
            if(slow == fast)
                return true;
        }
        return false;
    }
    // using HashSet
    public boolean hasLoop(Node head) {
        HashSet<Node> hashSet = new HashSet<Node>();
        Node temp = head;
        while (temp != null) {
            if (hashSet.contains(temp))
                return true;
            hashSet.add(temp);
            temp = temp.next;
        }
        return false;
    }
    /**
     * Approach:
     *
     * Find the Loop
     * Take two pointers, both starts from head
     * Move one pointer with normal speed and another with double speed
     * If both pointers meets at some point, we have found the loop
     * Now find the loop length
     * At the point where both pointers have met, stop one pointer and keep moving the another one
     * When another pointer meets the first pointer, stop.
     * Keep counting number of hops, that will your loop length
     * Now To break the loop
     * Move one pointer by the loop length
     * Now move both pointers with normal speed.
     * When secondpointer.next = first pointer, set secondpinter.next=null.
     */
    public void findLoopLength(Node one, Node two) {
        one = one.next;
        int length = 1;
        while (one != two) {
            one = one.next;
            length++;
        }
        System.out.println("Loop Length: " + length);
    }

    public void breakLoop(Node one, Node two) {
        one = one.next;
        while(one.next != two) {
            one = one.next;
        }
        one.next = null;
        System.out.println("Loop Breaks");
    }

    // Make loop in the linked list
    public void makeLoop(Node head, int x) {
        if(x == 0)
            return;
        Node curr = head;
        Node last = head;
        int counter = 0;
        while (counter < x) {
            curr = curr.next;
            counter++;
        }

        while(last.next != null) {
            last = last.next;
        }
        last.next = curr;
    }
   public void removeTheLoop(Node head) {
       Node temp=head;
       HashSet<Node> h1=new HashSet<>();
       int r=0;
       while(temp.next!=null)
       {
           if(h1.contains(temp.next))
           {
               temp.next=null;
               r=1;
               break;
           }
           else
           {
               h1.add(temp);
               temp=temp.next;
           }

       }
   }

   //flatten the list
//    public List<AnyType> flattenTheList(List<List<Object>> lists) {
//        List<List<Object>> list = new java.util.LinkedList<>();
//        List<Object> flat =
//                list.stream()
//                        .flatMap(List::stream)
//                        .collect(Collectors.toList());
//
//        return list;
//    }

    //delete a node
    public Node<AnyType> deleteNodeAtPosition(Node<AnyType> head, int position) {
        if(position == 0) {
            Node<AnyType> newHead = head.next;
            return newHead;
        }

        Node<AnyType> temp = head;
        for(int k=1; k<position; k++) {
            temp = temp.next;
        }

        Node<AnyType> newNext = temp.next.next;
        temp.next = newNext;
        return head;
    }




    /**
     * Dutch Sort in Linked List
     * What is important to maintain relative ordering when
     * performing dutch sort on a linked list?
     * Ans: Tracking head and tail of 3 list
     * Dutch sort is similar to quick sort
     * uses 3 lists
     * pick an x or a node with parti. value, make it as a pivot
     * As iterating through the nodes:
     * 1st list: put values < x
     * 2nd list: values = x
     * 3rd list: values > x
     * then connect the 2list head to 1st list tail and
     * 3rd list head to 2nd list tail
     */
    /*************
     * ListNode class
     */
    private static class Node<AnyType> {
        private AnyType data;
        private Node<AnyType> next;

        public Node(AnyType data, Node<AnyType> next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * The Iterator class
     */
    public Iterator<AnyType> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<AnyType> {
        private Node<AnyType> nextNode;

        public LinkedListIterator(){
            nextNode = head;
        }

        public boolean hasNext(){
            return nextNode != null;
        }

        public AnyType next(){
            if (!hasNext())
                throw new NoSuchElementException();
            AnyType res = nextNode.data;
            nextNode = nextNode.next;
            return res;
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
}
