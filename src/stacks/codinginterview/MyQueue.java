package stacks.codinginterview;
/*
 * ketnakhalasi created on 8/9/21
 * */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;

public class MyQueue<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int front;
    private int rear;
    private int size;
    private int capacity; //capacity of the queue, this is doubled when exceeded.
    private E[] queue;

    public MyQueue() {
        queue = (E[]) Array.newInstance(Object[].class.getComponentType(), DEFAULT_CAPACITY);
        front = 0; //index of first element
        rear = -1; //initially there is no element in the queue
        size = 0; // initially size of queue is 0
        capacity = DEFAULT_CAPACITY; // initially, capacity is DEFAULT_CAPACITY
    }
    // add element in queue in rear
    public void enqueue(E e) {
        if(isFull()) {
            ensureCapacity();
        }
        rear = (rear+1) % capacity;
        queue[rear] = e;
        size++;
    }
    //remove element from front
    public E dequeue() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        E e = queue[front];
        queue[front] = null;

        //set the new front
        front = (front + 1) % capacity;
        //decrease size of queue
        size--;
        return  e;
    }

    public E peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return queue[front];
    }

    public void ensureCapacity() {
        int newSize = queue.length * 2;
        queue = Arrays.copyOf(queue, newSize);
        capacity = newSize;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
