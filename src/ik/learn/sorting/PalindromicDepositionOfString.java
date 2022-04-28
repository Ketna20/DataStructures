package ik.learn.sorting;
/*
 * ketnakhalasi created on 4/26/22
 * */

import java.util.ArrayList;

public class PalindromicDepositionOfString {
    public static void main(String[] args) {
//        ArrayList<String> result = generate_palindromic_decompositions("abracadabra");

       ArrayList<String> result = generate_palindromic_decompositions("aa");
       System.out.println(result.toString());
    }


    static ArrayList<String> generate_palindromic_decompositions(String s) {
        // Write your code here.
        ArrayList<String> output = new ArrayList<>();
        char[] slate = new char[s.length()*2];
        helper(s.toCharArray(), 0, 0, slate, output);
        return output;
    }

    static void helper(char[] input, int index, int j, char[] slate, ArrayList<String> result) {


        if(index == input.length) {
            //slate.deleteCharAt(slate.length - 1);

            result.add(new String(slate, 0, j-1));
            return;
        }

        for(int i=index; i< input.length; i++) {
            slate[j] = input[i];
            j++;

            if(isPalindrome(input, index, i)) {
                slate[j] = '|';


                helper(input, i+1, j+1, slate, result);
            }
        }

    }

    static private boolean isPalindrome(char[] input, int left, int right) {

        while(left <= right) {
            if (input[left++] != input[right--]) {
                return false;
            }
        }
        return true;
    }
}
