package ik.learn.binarySearch;
/*
 * ketnakhalasi created on 9/2/22
 * Leetcode premium : 1231
 * */

import java.util.Arrays;

public class DivideChocolate {

    public static void main(String[] args) {

        int[] sweetness = {1,2,3,4,5,6,7,8,9}; //output: 6 -> [1,2,3],[4,5],[6],[7],[8],[9]
        int k=5;
//        int[] sweetness = {1,2,2,1,2,2,1,2,2}; //output: 5 ->[1,2,2],[1,2,2],[1,2,2]
//        int k=2;

        int mySweetness = maximizeSweetness(sweetness, k);
        System.out.println("mySweetness: " + mySweetness);
    }

    public static int maximizeSweetness(int[] sweetness, int k) {
        int start = Arrays.stream(sweetness).min().getAsInt();
        int end = Arrays.stream(sweetness).sum();

        while(start <= end) {
            int mid = start + (end-start)/2;
            int numOfPieces = getSweetPieces(sweetness, mid);
            if(numOfPieces < k+1) {
                end = mid-1;
            } else {
                start = mid +1;
            }
        }
        return end;

    }

    private static int getSweetPieces(int[] sweetness, int mid) {
        int numOfPieces = 0;
        int load = 0;
        for(int i=0; i<sweetness.length-1; i++) {
            load += sweetness[i];
            if(load >= mid){
                numOfPieces++;
                load = 0;
            }
        }
        return numOfPieces;
    }
}
