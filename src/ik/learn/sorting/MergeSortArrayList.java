package ik.learn.sorting;
/*
 * ketnakhalasi created on 4/19/22
 * */

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MergeSortArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> unsortedList = new ArrayList<>();
        unsortedList.add(5);
        unsortedList.add(7);
        unsortedList.add(3);
        unsortedList.add(8);
        unsortedList.add(1);
        unsortedList.add(4);
        unsortedList.add(9);
        unsortedList.add(2);

        System.out.println("Unsorted ArrayList:" + unsortedList);
        ArrayList<Integer> result = merge_sort(unsortedList);
//        ArrayList<Integer> sortedlist = divide(unsortedList, 0, unsortedList.size() - 1);
        System.out.println("Sorted List: " + result);
    }

    /*
    Asymptotic complexity in terms of size of `arr` `n`:
    * Time: O(n * log(n)).
    * Auxiliary space: O(n * log(n)).
    * Total space: O(n * log(n)).
    */
    static ArrayList<Integer> merge_sort(ArrayList<Integer> arr) {
        int n = arr.size();
        int left = 0, right = n - 1;
        split(arr, left, right);
        return arr;
    }

    /*function to partition the array into subarrays and then merge them*/
    static void split(List<Integer> arr, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            //sort first and second halves of the array
            split(arr, left, mid);
            split(arr, mid + 1, right);
            //merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    /*function to merge 2 sorted arrays*/
    static void merge(List<Integer> arr, int left, int mid, int right) {
        int[] l = new int[mid - left + 1];
        //copies the integers to array l from arr
        for(int i = 0; i < mid - left + 1; i++) {
            l[i] = arr.get(left + i);
        }
        int[] r = new int[right - mid];
        //copies the integers to array r from arr
        for(int i = 0; i < right - mid; i++) {
            r[i] = arr.get(mid + i + 1);
        }
        int i = 0, j = 0, k = left;
        //merges arrays l and r back to arr
        while(i < l.length && j < r.length) {
            if(l[i] <= r[j]) {
                arr.set(k, l[i]);
                i++;
            }
            else {
                arr.set(k, r[j]);
                j++;
            }
            k++;
        }
        //merges remaining elements of arrays l and r
        while(i < l.length) {
            arr.set(k++, l[i++]);
        }
        while(j < r.length) {
            arr.set(k++, r[j++]);
        }
    }


}

