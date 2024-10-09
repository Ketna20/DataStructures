package LeetCode.dp;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs_70 {

    public static void main(String[] args) {
        int steps = climbStairsSpaceOptimization(10);
        System.out.println(steps);
    }

    public static int climbStairsRecursion(int n) {
        if(n == 0 || n == 1) return 1;

        return climbStairsRecursion(n-1) + climbStairsRecursion(n-2);
    }

    public int climbStairsMemoization(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return climbStairs(n, memo);
    }

    private int climbStairs(int n, Map<Integer,Integer> memo) {
        if(n == 0 || n == 1) return 1;

        if(!memo.containsKey(n)) {
            memo.put(n, climbStairs(n-1, memo) + climbStairs(n-2, memo));
        }
        return memo.get(n);
    }

    public int climbStairsTabulation(int n) {
        if(n == 0 || n == 1) return 1;
        int[] t = new int[n+1];
        t[0] = 0;
        t[1] = 1;
        t[2] = 2;

        for(int i=3; i<=n; i++) {
            t[i] = t[i-1] + t[i-2];
        }
        return t[n];
    }

    public static int climbStairsSpaceOptimization(int n) {
        // space optimization approach
        if(n == 0 || n == 1)
            return 1;


        int prev = 1;
        int current = 1;
        for(int i = 2; i <= n; i++) {
            int t = current;
            current += prev;
            prev = t;

        }
        return current;
    }
}
