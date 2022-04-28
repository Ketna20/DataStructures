package ik.learn.sorting;
/*
 * ketnakhalasi created on 4/20/22
 * Example
{
"first": [1, 3, 5],
"second": [2, 4, 6, 0, 0, 0]
}
Output:

[1, 2, 3, 4, 5, 6]
 * */

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] f = {1, 3, 5};
        int[] s = {2, 4, 6, 0, 0, 0};
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a1.add(3);
        a1.add(5);
        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(2);
        a2.add(4);
        a2.add(6);
        a2.add(0);
        a2.add(0);
        a2.add(0);
        System.out.println("a1: " + a1);
        System.out.println("a2: " + a2);
//        System.out.println("Orig Second Array: ");
//        for(int i=0; i<s.length; i++){
//            System.out.print(s[i] + " ");
//        }
//
//        int fn = f.length;
//        int fArrIndex = 0;
//        for(int i=fn; i< s.length; i++){
//            s[i] = f[fArrIndex++];
//        }
//
//        System.out.println("After insert Second Array: ");
//
//        for(int i=0; i<s.length; i++){
//            System.out.print(s[i] + " ");
//        }
        ArrayList<Integer> merged = merge_one_into_another(a1, a2);
        System.out.println("merged: " + merged);

    }
    static ArrayList<Integer> merge_one_into_another(ArrayList<Integer> first, ArrayList<Integer> second) {
        //insert the first array into second
        int fn = first.size();
        int fArrIndex = 0;
        for(int i=fn; i< second.size(); i++){
            second.set(i, first.get(fArrIndex++));
        }
        int left = 0;
        int right = second.size()-1;
        System.out.println("second: " + second);
        divide(second, left, right);

        return second;
    }

    private static void divide(ArrayList<Integer> second, int left, int right) {
        if(left<right) {
            int mid = (left+right)/2;
            divide(second, left, mid);
            divide(second, mid+1, right);
            merge(second, left, mid, right);
        }
    }

    private static void merge(ArrayList<Integer> second, int left, int mid, int right) {
        int[] l = new int[mid-left+1];
        for(int i=0; i<mid-left+1; i++) {
            l[i] = second.get(left+i);
        }
        int[] r = new int[right-mid];
        for(int i=0; i<right-mid; i++) {
            r[i] = second.get(mid+i+1);
        }

        int i=0;
        int j=0;
        int k=left;
        while(i<l.length && j<r.length) {
            if(l[i]<=r[j]){
                second.set(k, l[i]);
                i++;
            } else {
                second.set(k, r[j]);
                j++;
            }
            k++;
        }
        while (i < l.length) {
            second.set(k++, l[i++]);
        }

        while(j < r.length) {
            second.set(k++, r[j++]);
        }

    }

}
