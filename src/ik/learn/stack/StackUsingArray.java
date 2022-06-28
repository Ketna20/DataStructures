package ik.learn.stack;
/*
 * ketnakhalasi created on 6/27/22
 * */

public class StackUsingArray {

    int[] arr;
    int top;
    int capacity;

    public StackUsingArray(int capacity){
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.top = -1;
    }

    public void push(int x){
        if(isFull()) {
            System.out.println("Stack is full.");
        }
         else {
             arr[++top] = x;
        }
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return arr[top--];
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return arr[top];
    }

    public boolean isFull() {
        return top+1 == capacity;
    }

    public boolean isEmpty(){
        return top == -1;
    }
}
