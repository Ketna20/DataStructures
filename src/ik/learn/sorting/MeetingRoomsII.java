package ik.learn.sorting;


import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/*Leetcode 253: Premium
* Given array of intervals with [start, end] times.
* Return the minimum number of conference rooms required.
* ex:1 input : intervals = [[0,30], [5,10], [15,20]]  Output=2.
* ex:2 input : intervals = [[7,10], [2,4]]  Output=1.
* */
public class MeetingRoomsII {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> intervals = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> interval1 = new ArrayList<>();
        interval1.add(0);
        interval1.add(30);
        ArrayList<Integer> interval2 = new ArrayList<>();
        interval2.add(5);
        interval2.add(10);
        ArrayList<Integer> interval3 = new ArrayList<>();
        interval3.add(15);
        interval3.add(20);
        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);

        ArrayList<ArrayList<Integer>> intervals1 = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> interval4 = new ArrayList<>();
        interval4.add(7);
        interval4.add(10);
        ArrayList<Integer> interval5 = new ArrayList<>();
        interval5.add(2);
        interval5.add(4);
        intervals1.add(interval4);
        intervals1.add(interval5);

        int confRoom = MinConferenceRooms(intervals);
        System.out.println("ConfRoom : " + confRoom);

        int confRoom1 = MinConferenceRooms(intervals1);
        System.out.println("ConfRoom1 : " + confRoom1);

    }

    public static int MinConferenceRooms(ArrayList<ArrayList<Integer>> intervals) {
        Collections.sort(intervals, (a, b) -> a.get(0)-b.get(0));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int globalmax = 0;
        int nextStart = 0;
        for(int i=0; i <= intervals.size()-1; i++) {
            if(i == intervals.size()-1) {
                nextStart = Integer.MAX_VALUE;
            } else {
                nextStart = intervals.get(i+1).get(0);
            }
            pq.offer(intervals.get(i).get(1));
            globalmax = Math.max(globalmax, pq.size());

            while(!pq.isEmpty() && pq.peek() <= nextStart) {
                pq.poll();
            }
        }

        return globalmax;

    }
}
