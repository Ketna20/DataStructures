package ik.learn.dp;
/*
 * ketnakhalasi created on 5/18/22
 * */

import java.util.ArrayList;
import java.util.Arrays;

public class Robbery {
    public static void main(String[] args) {
//        int[] values = {6, 1, 2, 7};
        ArrayList<Integer> values  = new ArrayList<>();
        values.add(6);
        values.add(1);
        values.add(2);
        values.add(7);

        int max = maximum_stolen_value1(values);
        System.out.println("Maximum Value: " + max);
    }
    static Integer maximum_stolen_value(ArrayList<Integer> values) {
        int[] dp = new int[values.size()+1];


        dp[1]=values.get(0);

        for(int i=2;i<=values.size();i++){
            dp[i]=Math.max(dp[i-1], dp[i-2]+ values.get(i-1));
        }

        return dp[values.size()];
    }

    static Integer maximum_stolen_value1(ArrayList<Integer> values) {
        int memo[] = new int[values.size()];
        Arrays.fill(memo, -1);

        if(values==null || values.isEmpty()) return 0;

        for(int i=0; i<values.size(); i++) {
            if(i==0) {
                memo[0] = values.get(0);
            } else if (i==1) {
                memo[1] = Math.max(values.get(0), values.get(1));
            } else {
                memo[i] = Math.max(memo[i-1], memo[i-2]+values.get(i));
            }
        }

        return memo[values.size()-1];
    }

}
