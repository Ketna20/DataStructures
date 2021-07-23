package bigOAnalysis;
/*
 * ketnakhalasi created on 7/22/21
 * */

public class FibonacciTabulation {

    public static void main(String[] args) {
        int m = fibonacci(10);
        System.out.println(m);
    }

    public static int fibonacci(int k) {
        if (k <= 1) return k;

        int first = 1;
        int second = 0;
        int result = 0;
        for(int i=1; i < k; i++) {
            result = first + second;
            second = first;
            first = result;
        }
        return result;
    }
}
