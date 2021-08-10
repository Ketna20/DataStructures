package stacks.codinginterview;
/*
 * ketnakhalasi created on 8/9/21
 * */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int top;
    private E[] stack;

    public MyStack() {
        stack = (E[]) Array.newInstance(Object[].class.getComponentType(), DEFAULT_CAPACITY);
        top = 0; //initial size
    }

    public void push(E e) {
        //if stack is full, double the capacity
        if(isFull()){
            ensureCapacity();
        }
        // add element on top
        stack[top++] = e;
    }

    public void ensureCapacity() {
        int newSize = stack.length * 2;
        stack = Arrays.copyOf(stack, newSize);
    }

    public boolean isFull() {
        return top == stack.length;
    }

    public E pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        // extract top element
        E e = stack[--top];

        //avoid memory leak
        stack[top] = null;

        return e;

    }

    public boolean isEmpty() {
        return top == 0;
    }

    public E peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top-1];
    }

    public int size() {
        return top;
    }
}
