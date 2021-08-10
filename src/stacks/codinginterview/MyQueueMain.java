package stacks.codinginterview;
/*
 * ketnakhalasi created on 8/9/21
 * */

public class MyQueueMain {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.enqueue(24);
        myQueue.enqueue(12);
        myQueue.enqueue(4);
        myQueue.enqueue(30);
        myQueue.enqueue(21);

        System.out.println("Size: " + myQueue.size());
        System.out.println("Peek: " + myQueue.peek());
        System.out.println("Size: " + myQueue.size());

        System.out.println("Pop: " + myQueue.dequeue());
        System.out.println("Size: " + myQueue.size());
        System.out.println("Push 17");
        myQueue.enqueue(17);
        System.out.println("Size: " + myQueue.size());
    }
}
