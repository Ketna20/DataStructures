package ik.learn.sorting;
/*Leetcode 1094:
 * There is a car with capacity empty seats. The vehicle only drives east
 * (i.e., it cannot turn around and drive west).
You are given the integer capacity and an array trips
* where trips[i] = [numPassengersi, fromi, toi] indicates that the ith trip has
* numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively.
 The locations are given as the number of kilometers due east from the car's initial location.
 * Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 4   Output: false
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 5   Output: true
 */
public class CarPooling {

    public static boolean carPooling(int[][] trips, int capacity) {
        int stops[] = new int[1001];
        for (int t[] : trips) {
            stops[t[1]] += t[0];
            stops[t[2]] -= t[0];
        }
        for (int i = 0; capacity >= 0 && i < 1001; ++i) capacity -= stops[i];
        return capacity >= 0;
    }

    public static void main(String[] args) {
        int[][] trips = new int[2][3];
        // {2, 1, 5},{3, 3, 7}
        trips[0][0] = 2;
        trips[0][1] = 1;
        trips[0][2] = 5;

        trips[1][0] = 3;
        trips[1][1] = 3;
        trips[1][2] = 7;

        boolean isPossible = carPooling(trips, 4);
        System.out.println("isPossible: " + isPossible);
    }
}
