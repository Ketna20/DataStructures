package Queues;
/*
 * ketnakhalasi created on 8/17/20
 * */
/* this method 2 makes deQueue operation costly.
 * This method is better than method1, making enQueue costly, because
 * methpd 1 moves all elements twice
 * method 2 moves elements once only if stack2 is empty.
 */

import java.util.Stack;

public class QueueUsingStacks2 {

    static class myQueue {
        static Stack<Integer> s1;
        static Stack<Integer> s2;
    }


    static void push(Stack<Integer> top_ref, int new_data){
        // push the data onto the stack
        top_ref.push(new_data);
    }

    //function to pop an item from stack
    static int pop(Stack<Integer> top_ref) {
        //if stack is empty then error
        if(top_ref.isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(0);
        }

        //pop data from stack
        return top_ref.pop();
    }

    static void enQueue(myQueue q, int x) {
        push(q.s1, x);
    }

    static int deQueue(myQueue q) {
        int x;
        //if both stacks are empty then error
        if (q.s1.isEmpty() && q.s2.isEmpty()) {
            System.out.println("Q is empty.");
            System.exit(0);
        }
        // move elements from s1 to s2 only if s2 is empty
        if(q.s2.isEmpty()) {
            while (!q.s2.isEmpty()) {
                x = pop(q.s1);
                push(q.s2, x);
            }
        }
        x = pop(q.s2);
        return x;
    }

}
