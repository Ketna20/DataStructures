package ik.learn.sorting;
/*
 * ketnakhalasi created on 4/18/22
 * */

import java.util.ArrayList;

public class EvenOddNumbers {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        System.out.println(arrayList.size());
        ArrayList<Integer> segreArrayList = segregateEvenOdd(arrayList);
        System.out.println(segreArrayList);

    }

    public static ArrayList<Integer> segregateEvenOdd(ArrayList<Integer> numbers) {
        ArrayList<Integer> myEvenList = new ArrayList<>();
        ArrayList<Integer> myOddList = new ArrayList<>();
        int size = numbers.size();
        int start = 0;
        for (Integer i : numbers) {
            if (i % 2 == 0) {
                myEvenList.add(i);
            }
            else {
                myOddList.add(i);
            }
        }
        myEvenList.addAll(myOddList);
            return myEvenList;
    }

}
