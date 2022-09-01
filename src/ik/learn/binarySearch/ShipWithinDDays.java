package ik.learn.binarySearch;
/*
 * ketnakhalasi created on 8/31/22
 * */

import java.util.Arrays;

public class ShipWithinDDays {
    public static void main(String[] args) {
        int[] weights = {3, 2, 2, 4, 1, 4};
        int days = 3;
        int minWeightCap = shipWithinDays(weights, days);
        System.out.println("minWeightCap : " + minWeightCap);
    }

    public static int shipWithinDays(int[] weights, int days) {
        if(weights.length == days) {
            return Arrays.stream(weights).max().getAsInt();
        }

        int start = Arrays.stream(weights).max().getAsInt();
        int end = Arrays.stream(weights).sum();

        while(start <= end) {
            int mid = start + (end - start)/2; //let's say mid is the weight capacity/day
            int daysToShip = 1;
            int load = 0;
            for(int i=0; i<weights.length; i++){
                load += weights[i];
                if(load > mid) {
                    daysToShip += 1;
                    load = weights[i];
                }
            }
            // #days = days it would take to ship all the items.
            if(daysToShip > days) {
                start = mid+1;
            } else
                end = mid-1;
        }

        return start;

    }
}
