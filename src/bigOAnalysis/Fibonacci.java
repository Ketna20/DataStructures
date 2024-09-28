package bigOAnalysis;
/*
 * ketnakhalasi created on 7/21/21
 * */

public class Fibonacci {

    public static void main(String[] args) {
        int n = 10;
        for(int i=0; i < n; i++){
            System.out.print(fibonacci(i) + " ");
        }
    }

    //recursive solution Big O(2^n) - bad performance.
    public static int fibonacci(int k) {
        if(k <= 1) {
            return k;
        }
        return fibonacci(k-1) + fibonacci(k-2);
    }

    //time complexity O(n) and Space O(1)
    public int fib(int n) {
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
