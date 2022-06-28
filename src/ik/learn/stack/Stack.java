package ik.learn.stack;
/*
 * ketnakhalasi created on 6/27/22
 * */

import org.graalvm.compiler.asm.amd64.AMD64Address;

import java.util.ArrayList;

public class Stack<T> {
    ArrayList<T> arr;
    int top = -1;
    int size;

    public Stack() {
    }

    public Stack(int size) {
        this.arr = new ArrayList<T>(size);
        this.size = size;
    }

    public void push(T x) {
        if(isFull())
            System.out.println("stack is full");

        top++;
        arr.add(x);
    }

    public T pop() {
        if(isEmpty()){
            System.out.println("Stack is empty.");
            return null;
        }
        T topElement = arr.get(top);
        top--;
        return topElement;
    }

    public T peek() {
        if(isEmpty()){
            return null;
        }
        return arr.get(top);
    }

    public boolean isFull() {
        return top == size -1;
    }
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public String toString() {
        String Ans = "";

        for (int i = 0; i < top; i++) {
            Ans += String.valueOf(arr.get(i)) + "->";
        }

        Ans += String.valueOf(arr.get(top));
        return Ans;
    }
}
