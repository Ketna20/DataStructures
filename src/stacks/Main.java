package stacks;
/*
 * ketnakhalasi created on 7/8/20
 * */

public class Main {

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
        System.out.println(myStack.top + " is the top element in the Stack.");
    }
}
