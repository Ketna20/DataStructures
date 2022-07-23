package ik.learn.stack;
/*
 * ketnakhalasi created on 7/2/22
 * */

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> q;
    int size;

    public StackUsingQueue(){
        Queue<Integer> q = new LinkedList<>();
        size = 0;
    }

    public void push(int x) {
        q.offer(x);
        size++;
        while(!q.isEmpty()){
            q.offer(q.poll());
        }
    }

    public int pop() {
        if(!q.isEmpty()){
            size--;
            return q.poll();
        }

        return -1;
    }

    public int top() {
        if(!q.isEmpty()){
            return q.peek();
        }
        return -1;
    }

    public  boolean isEmpty() {
        return q.isEmpty();
    }
}
