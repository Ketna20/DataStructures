package stacks.codinginterview;
/*
 * ketnakhalasi created on 8/9/21
 * */

public class MyStackMain {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(25);
        myStack.push(35);
        myStack.push(15);
        System.out.println("Size: " + myStack.size());
        System.out.println("Peek: " + myStack.peek());
        System.out.println("Size: " + myStack.size());

        System.out.println("Pop: " + myStack.pop());
        System.out.println("Size: " + myStack.size());
        System.out.println("Push 17");
        myStack.push(17);
        System.out.println("Size: " + myStack.size());
        System.out.println("Peek: " + myStack.peek());
        System.out.println(" Is Full: " + myStack.isFull());
    }
}
