package ik.learn.arrays;
/*
 * ketnakhalasi created on 8/10/22
 * */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
// Given an array of integers arr of size n and an integer w,
// find maximum number in all subarrays of arr of length w.
// Imagine that n is very large and a sliding window of a
// smaller size w is moving through arr from left to right.
// We need to find the maximum in every position of the sliding window.
// ex: arr: [1, 3, -1, -3, 5, 3, 6, 7]
//output : [3, 3, 5, 5, 6, 7]
//explanation:
//[1 3 -1] -3 5 3 6 7. Maximum is 3.
//1 [3 -1 -3] 5 3 6 7. Maximum is 3.
//1 3 [-1 -3 5] 3 6 7. Maximum is 5.
//1 3 -1 [-3 5 3] 6 7. Maximum is 5.
//1 3 -1 -3 [5 3 6] 7. Maximum is 6.
//1 3 -1 -3 5 [3 6 7]. Maximum is 7.

public class MaxSlidingWindow {

    public static ArrayList<Integer> max_sliding_window(ArrayList<Integer> arr, Integer w){
        if(w == 1) return arr;

        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> maxQueue = new LinkedList<>();

        for(int i= 0; i<w; i++){
            if(maxQueue.isEmpty()) {
                maxQueue.offer(arr.get(i));
            } else {
                while(!maxQueue.isEmpty() && maxQueue.peekLast() < arr.get(i)) {
                    maxQueue.removeLast();
                    maxQueue.offer(arr.get(i));
                }
            }
        }
        result.add(maxQueue.peekFirst());

        for(int index = w; index < arr.size(); index++){
            if(maxQueue.peekFirst() == arr.get(index)) {
                maxQueue.removeFirst();
            }
            while(!maxQueue.isEmpty() && maxQueue.peekLast() < arr.get(index)){
                maxQueue.removeLast();
            }
            maxQueue.offer(arr.get(index));
            result.add(maxQueue.peekFirst());
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        //1, 3, -1, -3, 5, 3, 6, 7
        arr.add(1);
        arr.add(3);
        arr.add(-1);
        arr.add(-3);
        arr.add(5);
        arr.add(3);
        arr.add(6);
        arr.add(7);
        int w = 3;
        ArrayList<Integer> result = max_sliding_window(arr, w);
        for(Integer i : result){
            System.out.print(i + ", ");
        }

    }
}
