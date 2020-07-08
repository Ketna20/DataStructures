package stacks;
/*
 * ketnakhalasi created on 7/8/20
 * */

public class StackAsLinkedList {
    StackNode root;

    class StackNode {
        int data;
        StackNode next;

        StackNode(int data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void push(int data) {

       StackNode newNode = new StackNode(data);
       if(root == null) {
           root = newNode;
       } else {
           StackNode temp = root;
           root = newNode;
           //root.next = temp;
           newNode.next = temp;
       }
        System.out.println(data + " pushed to stack");
    }

    public int pop() {
        int poppedData = Integer.MIN_VALUE;
        if(root == null) {
            System.out.println("Stack is empty.");
        } else {
            poppedData = root.data;
            root = root.next;
        }
        return poppedData;
    }

    public int peek() {
        if(root == null) {
            System.out.println("Stack is empty.");
            return Integer.MIN_VALUE;
        } else {
            return root.data;
        }
    }

}
