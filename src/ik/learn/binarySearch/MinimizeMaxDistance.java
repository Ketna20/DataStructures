package ik.learn.binarySearch;
/*
 * ketnakhalasi created on 9/1/22
 * Bi-section search problem
 * Leetcode Premium #774 Minimize Max Distance to Gas Station
 * On horizontal number line, gast stations are given
 * at positions stations[0],stations[1],...stations[n-1]
 * we add k more gas stations so that D, the max distance between
 * adjacent gas station is minimized.
 * Return smallest possible value of D
 * example: INPUT: stations = [1,2,3,4,5,6,7,8,9,10] k=9
 * output = 0.50000
 * Answers within 10^6 of the true value will be accepted as correct.
 * */

public class MinimizeMaxDistance {

    public static void main(String[] args) {
        int[] stations = {1, 3, 4, 8, 10};
        int k = 5;
        float distance = getMinDistance(stations, k);
        System.out.println("distance: " + distance);
    }
        public static float getMinDistance(int[] stations, int k) {
            float startD = 0;
            float endD = 0;
            for(int i=0; i<=stations.length-2; i++) {
                endD = Math.max(endD, stations[i + 1] - stations[i]);
            }
            // endD is at upper bound now. The max distance between two adjacent gas stations.
            System.out.println("endD: " + endD);
            while(startD <= (endD-0.00001)) {
                float midD = startD + (endD-startD)/2;
                int numOfStations = calculateK(stations, midD);
                System.out.println("numOfStations: " + numOfStations + "midD: " + midD);
                if (numOfStations > k) {
                    startD = midD;
                } else {
                    endD = midD;
                }
            }
            return startD;

        }

        public static int calculateK(int[] stations, float midD) {
            int numOfStations = 0;
            for (int i=0; i<=stations.length-2; i++) {
                numOfStations += Math.ceil(stations[i+1] - stations[i]/midD) - 1;
            }
            return numOfStations;
        }
}
