package ik.learn.adhoc;
/*
 * ketnakhalasi created on 9/10/22
 * */

import java.util.HashMap;
import java.util.Map;

public class MathCalculations {

    public static void main(String[] args) {
        int n = 123;
        System.out.println(numberToWords(123));
    }

    public static String numberToWords(int num) {
        if(num == 0) return "Zero";

        Map<Integer, String> names = new HashMap<>();
        names.put(1, "One"); names.put(2, "Two");  names.put(3, "Three"); names.put(4, "Four");
        names.put(5, "Five"); names.put(6, "Six");  names.put(7, "Seven"); names.put(8, "Eight");
        names.put(9, "Nine"); names.put(10, "Ten");  names.put(11, "Eleven"); names.put(12, "Twelve");
        names.put(13, "Thirteen"); names.put(14, "Fourteen");  names.put(15, "Fifteen"); names.put(16, "Sixteen");
        names.put(17, "Seventeen"); names.put(18, "Eighteen");  names.put(19, "Nineteen");
        names.put(20, "Twenty"); names.put(30, "Thirty");  names.put(40, "Forty"); names.put(50, "Fifty");
        names.put(60, "Sixty"); names.put(70, "Seventy");  names.put(80, "Eighty"); names.put(90, "Ninety");


        Long denominator = 1000000000L;
        StringBuilder ans = new StringBuilder();
        String[] suffix = {" Billion ", " Million ", " Thousand ", ""};
        for (int i=0; i<=3; i++) {
            //extract the relevant 3 digit number and get its name
            // and suffix it with corresponding suffix from suffix array
            int quotient = (int) (num / denominator);
            num = (int) (num % denominator);
            if(quotient > 0) {
                ans.append(threeDigitsToName(quotient, names) + suffix[i]);
            }
            denominator = denominator/1000;
        }
        return ans.toString();

    }

    public static String threeDigitsToName(int x, Map<Integer, String> names){
        if (x == 0)
            return "";
        int hundreds = x/100;
        int tens = (x%100)/10;
        int ones = x%10;

        StringBuilder s = new StringBuilder();
        if(hundreds > 0) {
            s.append(names.get(hundreds) + " Hundred ");
        }

        if(tens == 1) {
            s.append(names.get(x%100));
            return s.toString();
        }

        if(tens > 0) {
            s.append(names.get(tens*10));
            s.append(" ");
        }
        if(ones > 0) {
            s.append(names.get(ones));
        }
        return s.toString();
        }

}
