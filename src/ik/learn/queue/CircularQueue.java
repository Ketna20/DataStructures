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
//        if(isFull()) return false;
        if(isFull()) {
            resize(2*size);
        }
        count++;
        end = (end+1) % size;
        System.out.println("end: " + end);
        arr[end] = value;
        return true;
    }

    // resize the array and copy elements in new array with head to tail order
    // means example - 4 0 0 1 2 3 old array - size = 6
    // new array after copying elements - 1 2 3 4 0 0 0 0 0 0 0 0 - size = 12
    public void resize(int newSize) {
        int[] newArr = new int[newSize];
        int nextIndex = 0;

        //copy elements from old array to new Array
        while(front != end) {
            newArr[nextIndex] = arr[front];
            nextIndex++;
            front = (front+1) % size;
        }
        newArr[nextIndex] = arr[front];
        arr = newArr;
        front = 0;
        end = nextIndex - 1;
        size = newSize;
    }

    public boolean deQueue(){
        if(isEmpty()) return false;
        if(count == 1){
            arr[front] = -1;

        }
        front++;
        front=front%size;
        System.out.println("front: " + arr[front]);
        count--;
        arr[front] = -1;
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
