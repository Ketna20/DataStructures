package ik.learn.sorting;
/*
 * ketnakhalasi created on 4/19/22
 * */

import java.util.ArrayList;

public class TestMergeSortArraylist {
    public ArrayList<Integer> arrayList = new ArrayList<>();

    public ArrayList<Integer> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> unsortedList = new ArrayList<>();
        unsortedList.add(5);
        unsortedList.add(7);
        unsortedList.add(3);
        unsortedList.add(8);
        unsortedList.add(1);

//        this.arrayList.add(4);
//        this.arrayList.add(9);
//        this.arrayList.add(2);

        System.out.println("Unsorted ArrayList:" + unsortedList);
        ArrayList<Integer> sorted = merge_sort(unsortedList);
        System.out.println("final sorted: " + sorted);
    }

    static ArrayList<Integer> merge_sort(ArrayList<Integer> arr) {
        int start = 0;
        int end = arr.size() - 1;

        ArrayList<Integer> sortedList = divide(arr, start, end);

        return sortedList;
    }

    public static ArrayList<Integer> divide(ArrayList<Integer> arrayList, int start, int end) {
        ArrayList<Integer> list = new ArrayList<>();
        if (start < end)
//        if(start != end)
        {
            int mid = (start + end) / 2;
            divide(arrayList, start, mid);
            divide(arrayList, mid + 1, end);
            list = merge(arrayList, start, mid, end);
        }
//        else if(start == end) {
//            list.add(arrayList.get(0));
//        }
        return list;
    }

    static ArrayList<Integer> merge(ArrayList<Integer> a, int start, int mid, int end) {
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        int i = start;
        int j = mid+1;
//        int k = start;

        while(i <= mid && j <= end) {
            if(a.get(i) <= a.get(j)){
                sorted.add(a.get(i));
                System.out.println("1 sorted: " + sorted);
                i++;
//                k++;
            }else {
                sorted.add(a.get(j));
                System.out.println("2 sorted: " + sorted);
                j++;
//                k++;
            }
        }
        while(i<= mid){
            sorted.add(a.get(i));
            System.out.println("3 sorted: " + sorted);
            i++;
//            k++;
        }
        while(j<=end) {
            sorted.add(a.get(j));
            System.out.println("4 sorted: " + sorted);
            j++;
//            k++;
        }
        return sorted;
    }
}
