package ik.learn.sorting;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

        private PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        private boolean even = true;


    public void addNum(int num) {
        if(even) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            // Rebalance
            maxHeap.offer(minHeap.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if(even) {
            return (minHeap.peek() + maxHeap.peek())/2.0;
        } else {
            return minHeap.peek();
        }

    }


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
