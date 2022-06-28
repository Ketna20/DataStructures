package ik.learn.queue;
/*
 * ketnakhalasi created on 6/27/22
 * */


import ik.learn.stack.Stack;

public class QueueUsingTwoStacks {
    Stack<Integer> enqueueStack;
    Stack<Integer> dequeueStack;

    public QueueUsingTwoStacks() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    public void push(int x){
        enqueueStack.push(x);
    }
    public int pop() {
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.pop();
    }

    public int peek() {
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.peek();
    }

    public boolean isEmpty() {
        return dequeueStack.isEmpty() && enqueueStack.isEmpty();
    }
}
