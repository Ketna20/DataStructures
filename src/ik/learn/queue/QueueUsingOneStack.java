package ik.learn.queue;
/*
 * ketnakhalasi created on 6/28/22
 * */

import ik.learn.stack.Stack;

public class QueueUsingOneStack {
    Stack<Integer> stack;

    public QueueUsingOneStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(x);
        } else {
            while(!stack.isEmpty()){
                int p = stack.pop();
                stack.push(x);
                stack.push(p);
            }
        }
    }

    public int pop(){
        return stack.pop();
    }

    public int peek(){
        return stack.peek();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
}
