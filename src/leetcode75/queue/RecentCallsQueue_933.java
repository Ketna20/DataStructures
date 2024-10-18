package leetcode75.queue;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCallsQueue_933 {
    private Queue<Integer> queue;


    public RecentCallsQueue_933() {
        queue = new LinkedList<>();
    }
    public int ping(int t) {
        queue.add(t);
        while(queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}
