package ik.learn.sorting;
/*
 * ketnakhalasi created on 4/27/22
 * */

import java.util.Arrays;

public class BstCountWithNNodes {

    public static void main(String[] args) {
        int n = 6;
        int[] nodes = new int[n];
        nodes[0] = nodes[1] = 1;
        for(int i = 2; i < n; i++){
            nodes[i] = 0;
            for(int k=0; k<i; k++){
                nodes[i] += nodes[k] * nodes[i-k-1];
            }
        }
        for(int h = 0; h < nodes.length; h++){
            System.out.println(nodes[h] + ",");
        }

    }

}
