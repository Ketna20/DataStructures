package ik.learn.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortAllCharacters {


    public static void main(String[] args) {

        ArrayList<Character> arr = new ArrayList<>();
        arr.add('a');
        arr.add('s');
        arr.add('d');
        arr.add('f');
        arr.add('g');
        arr.add('*');
        arr.add('&');
        arr.add('!');
        arr.add('z');
        arr.add('y');
        ArrayList<Character> result = sort_array1(arr);
        System.out.println(result.toString());

    }
    public static ArrayList<Character> sort_array(ArrayList<Character> arr) {
        // Write your code here.
        ArrayList<Character> result = new ArrayList<>();
        int[] a = new int[128];

        for(Character ch:arr){
            a[ch]++;
        }

        for(int i=0; i<128; i++){
            while(a[i]-- > 0){
                result.add((char)i);
            }
        }

        return result;
    }

    //counting sort method
    static ArrayList<Character> sort_array1(ArrayList<Character> arr) {
        Integer[] array = new Integer[128]; // check this out 128 size of array
        Arrays.fill(array, 0); // fill all positions with 0

        //counting sort because input is not huge

        for(int i =0; i< arr.size() ; i++){
            Character c = arr.get(i);
            System.out.println("c : " + c + "(int)c: " + (int)c);
            array[(int)c]++;
        }

        arr.clear();
        for(int j=0; j<array.length; j++){
            int val = array[j];
            // System.out.println("val : " + val );
            while(val-- != 0){
                arr.add((char)(j));
                // System.out.println("char)(j) : " + (char)(j) );
            }
        }
        return arr;
    }
}
