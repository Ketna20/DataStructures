package ik.learn.sorting;

import java.util.PriorityQueue;

public class KthLargestInStream {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargestInStream(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int num : nums) add(num);
    }

    public int add(int val) {
        if (pq.size() < k || val > pq.peek()) pq.offer(val);
        if (pq.size() > k) pq.poll();
        return pq.peek();
    }
}
