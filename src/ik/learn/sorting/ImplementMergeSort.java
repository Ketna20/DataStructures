package ik.learn.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImplementMergeSort {

    public static void main(String[] args) {
        int[] nums = {2, 6, 1, 7, 9, 4, 3};
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(6);
        arr.add(1);
        arr.add(7);
        arr.add(9);
        arr.add(4);
        arr.add(3);
        merge_sort(arr);
        for(Integer i : arr) {
            System.out.println(i);
        }
    }

    static ArrayList<Integer> merge_sort(ArrayList<Integer> arr) {
        int start = 0;
        int end = arr.size() - 1;

        divide(arr, start, end);

        return arr;
    }

    public static void divide(ArrayList<Integer> arrayList, int start, int end) {

        if (start < end) {
            int mid = (start + end) / 2;
            divide(arrayList, start, mid);
            divide(arrayList, mid + 1, end);
            merge(arrayList, start, mid, end);
        }

    }

    static void merge(ArrayList<Integer> a, int start, int mid, int end) {
        int[] leftArr = new int[mid-start+1];
        for(int i=0; i<mid-start+1; i++) {
            leftArr[i] = a.get(start+i);
        }
        int[] rightArr = new int[end-mid];
        for(int j=0; j<end-mid; j++){
            rightArr[j] = a.get(mid+j+1);
        }
        int i = 0;
        int j = 0;
        int k = start;

        while(i < leftArr.length && j < rightArr.length) {
            if(leftArr[i] <= rightArr[j]){
                a.set(k, leftArr[i]);
                i++;
            }else {
                a.set(k, rightArr[j]);
                j++;
            }
            k++;
        }
        while(i < leftArr.length){
            a.set(k++, leftArr[i++]);

        }
        while(j < rightArr.length) {
            a.set(k++, rightArr[j++]);
        }

    }
}
