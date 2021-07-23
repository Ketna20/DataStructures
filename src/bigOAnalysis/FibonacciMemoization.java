package bigOAnalysis;
/*
 * ketnakhalasi created on 7/22/21
 * */

public class FibonacciMemoization {
    public static void main(String[] args) {

    }

    public static int fibonacci(int k) {
        return fibonacci(k, new int[k+1]);
    }

    public static int fibonacci(int k, int[] cache) {
        if(k <= 1) return k;
        else if(cache[k] > 0) {
            return cache[k];
        }
        cache[k] = fibonacci(k-2, cache) +
                fibonacci(k-1, cache);

        return cache[k];
    }
}
