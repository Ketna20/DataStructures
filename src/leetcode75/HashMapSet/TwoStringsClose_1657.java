package leetcode75.HashMapSet;

import java.util.Arrays;
public class TwoStringsClose_1657 {

    public static void main(String[] args) {
        String word1 = "xy";
        String word2 = "yx";

        boolean isClose = closeStrings(word1, word2);
        System.out.println("isClose: " + isClose);
    }

    public static void printArray(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static boolean closeStrings(String word1, String word2) {
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        for(char c: word1.toCharArray()){
            f1[c-'a']++;
        }
        System.out.println("f1: ");
        printArray(f1);
        System.out.println();
        for(char c: word2.toCharArray()){
//            if(f1[c-'a']==0) return false;
            f2[c-'a']++;
        }
        System.out.println("f2: ");
        System.out.println();
        printArray(f2);
        System.out.println();

        Arrays.sort(f1);
        Arrays.sort(f2);
        System.out.println("After sorting ");
        printArray(f1);
        System.out.println();

        printArray(f2);



        return Arrays.equals(f1,f2);
    }
}
