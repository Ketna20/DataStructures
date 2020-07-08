package stacks;
/*
 * ketnakhalasi created on 7/8/20
 * */

public class StackMain {

    public static void main(String[] args) {
        Stack myStack = new Stack();

        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push(40);
        myStack.push(50);
        myStack.push(60);
        System.out.println(myStack.pop() + " popped from myStack");
        System.out.println(myStack.peek() + " peeked from myStack");
        System.out.println(myStack.pop() + " popped from myStack");


        StackAsLinkedList sl = new StackAsLinkedList();
        System.out.println(sl.isEmpty());
        sl.push(100);
        sl.push(200);
        sl.push(300);
        sl.push(400);
        sl.push(500);
        sl.push(600);
        System.out.println(sl.isEmpty());
        System.out.println(sl.peek() + " peeked");
        System.out.println(sl.pop() + " popped");
        System.out.println(sl.peek() + " peeked");
    }
}
