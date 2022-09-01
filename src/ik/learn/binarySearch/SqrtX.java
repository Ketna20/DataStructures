package ik.learn.binarySearch;
/*
 * ketnakhalasi created on 8/27/22
 *
 * Leetcode #69
 * Input: 4 - Output : 2
 * Input: 8 - Output : 2
 * */

public class SqrtX {
    public static void main(String[] args) {
        int ans = sqrt(2147395599);
//        System.out.println("sqrt: " + Math.sqrt(2147395599));
        System.out.println(ans);
    }

    public static int sqrt(int x) {
        long start = 0;
        long end = x;
        while(start <= end) {
            long mid = start + (end - start)/2;
            long square = mid * mid;
            if(square == x) {
                return (int) mid;
            } else if (square < x) {
                start =  mid+1;
            } else {
                end = mid-1;
            }
        }
        return (int) end;
    }
}
