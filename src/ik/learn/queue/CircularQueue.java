package ik.learn.queue;
/*
 * ketnakhalasi created on 6/25/22
 * */

public class CircularQueue {
    int[] arr;
    int count = 0;
    int front = 0;
    int end = -1;
    int size = 0;

    public CircularQueue(int k) {
        arr = new int[k];
        size = k;
    }

    public boolean enQueue(int value){
        if(isFull()) return false;

        count++;
        end = (end+1) % size;
        arr[end] = value;
        return true;
    }

    public boolean deQueue(){
        if(isEmpty()) return false;

        front++;
        front=front%size;
        count--;
        return true;
    }

    public int front() {
        return isEmpty() ? -1 : arr[front];
    }

    public int rear() {
        return isEmpty() ? -1 : arr[end];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == size;
    }

}
