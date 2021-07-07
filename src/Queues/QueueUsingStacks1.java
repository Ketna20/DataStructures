package Queues;
/*
 * ketnakhalasi created on 8/17/20
 * */

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

/* Queue implementation using two stacks
 * The following class makes enQueue operation costly.
 */
public class QueueUsingStacks1 {

    static Stack<Integer> s1 = new Stack<Integer>();
    static Stack<Integer> s2 = new Stack<Integer>();

    /* Time Complexity of
     * push operation: O(N)
     * pop operation: O(1)
     * Auxiliary Space: O(N)
     */
    static void enQueue(int x) {
        //move all elements from s1 to s2
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        //then push onto s1
        s1.push(x);

        //push everything back to s1
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    static int deQueue() {
        //if first stack is empty
        if(s1.isEmpty()) {
            System.out.println("Q is empty.");
            System.exit(0);
        }

        //return top of s1
        return s1.pop();
    }
}
