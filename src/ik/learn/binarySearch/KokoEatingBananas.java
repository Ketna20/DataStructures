package ik.learn.binarySearch;
/*
 * ketnakhalasi created on 8/31/22
 * */

import java.util.Arrays;
import java.util.List;

public class KokoEatingBananas {
    public static void main(String[] args) {
       int[] piles = {3,6,7,11};
       int h = 8;
       int minHours = minEatingSpeed(piles, h);
        System.out.println("minEatingSpeed: " + minHours);


    }


    public static int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Arrays.stream(piles).max().getAsInt();

        while(start <= end) {
            int midk = start+(end-start)/2;

            //compute # of hours taken to eat all bananas at speed of midk
            long hrs = 0;
            for(int i=0; i <= piles.length-1; i++) {
                hrs +=Math.ceil((double) piles[i]/midk); // hrs she can take to eat all bananas at midk
                System.out.print(" + " + hrs);
//                if(piles[i] % midk == 0)
//                    hrs += piles[i]/midk; // hrs she can take to eat all bananas
//                else
//                    hrs += piles[i]/midk+1;
            }
            System.out.println();
            if(hrs > h) {
                start = midk+1;
            } else {
                end = midk-1;
            }
        }
        return start;
    }
}
