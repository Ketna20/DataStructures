package intervwPrep;
/*
 * ketnakhalasi created on 7/29/21
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pairs {
    public static void main(String[] args) {
        int[] a = {-5, -2, 5, 4, 3, 7, 2, 1, -1, -2, 15, 6, 12, -4, 3};
        int k = 10;
        List<String> pairs = findPairsSumEqualsK(a, k);
        System.out.println(pairs);
    }
     public static List<String> findPairsSumEqualsK(int[] a, int k) {
        if(a == null || a.length < 2) {
            return Collections.emptyList();
        }
        List<String> pairs = new ArrayList<>();
         Arrays.sort(a);
         int leftPointer = 0;
         int rightPointer = a.length -1;
         while(leftPointer < rightPointer){
             if(a[leftPointer] + a[rightPointer] == k) {
                 pairs.add("(" + a[leftPointer] + ", " + a[rightPointer] + ")");
                 leftPointer++;
                 rightPointer--;
             } else if(a[leftPointer] + a[rightPointer] < k) {
                 leftPointer++;
             } else if(a[leftPointer] + a[rightPointer] > k) {
                 rightPointer--;
             }
         }
        return pairs;
     }
}
