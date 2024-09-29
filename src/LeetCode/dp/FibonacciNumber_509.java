package LeetCode.dp;

import java.util.Arrays;

public class FibonacciNumber_509 {


    public static int fibonacciRecursion(int k) {
        if(k <= 1) {
            return k;
        }
        return fibonacciRecursion(k-1) + fibonacciRecursion(k-2);
    }

    public int FibMemoization(int n) {
        int[] fib = new int[n+1];
        Arrays.fill(fib, -1);
        return f(n, fib);
    }

    public int f(int n, int[] fib) {
        if(n <= 1) return n; // base case

        if(fib[n] != -1) return fib[n]; // step 2

        return fib[n] = f(n-1, fib) + f(n-2, fib); // step 3
    }

    public int FibTabulation(int n) {
        if(n <= 1) return n;

        int[] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;

        for(int i=2; i <= n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }

        return fib[n];
    }

    //time complexity O(n) and Space O(1)
    public int fibSpaceOptimization(int n) {
        if (n <= 1) return n;

        int prev1 = 0;
        int prev2 = 1;
        int current = 0;
        for(int i = 2; i<=n; i++) {
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }
        return current;
    }
}
