package leetcode75;

import java.util.Arrays;

public class NonOverlappingIntervals_435 {

    public static void main(String[] args) {
        // intervals = [[1,2],[2,3],[3,4],[1,3]]
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        int count = eraseOverlapIntervals(intervals);
        System.out.println("count: " + count);
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[1]-b[1]));

        int[] lastInterval = intervals[0];
        int size = 1;
        int counter = 0;

        for(int i =1; i<intervals.length; i++) {
            if(lastInterval[1] > intervals[i][0]) {
                counter++;
            } else {
                lastInterval = intervals[i];
                size++;
            }
        }

        return counter;
    }
}
