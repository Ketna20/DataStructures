package ik.learn.adhoc;
/*
 * ketnakhalasi created on 9/13/22
 * */

import java.util.HashMap;
import java.util.Map;

public class NumberToHex {

    public static void main(String[] args) {
        int n = 16;
        System.out.println("answer: " + toHex(n));
    }

    public static String toHex(int num) {
        if(num == 0) return "0";

        Map<Integer, String> hexSymbol = new HashMap<>();
        hexSymbol.put(0, "0");
        hexSymbol.put(1, "1");
        hexSymbol.put(2, "2");
        hexSymbol.put(3, "3");
        hexSymbol.put(4, "4");
        hexSymbol.put(5, "5");
        hexSymbol.put(6, "6");
        hexSymbol.put(7, "7");
        hexSymbol.put(8, "8");
        hexSymbol.put(9, "9");
        hexSymbol.put(10, "a");
        hexSymbol.put(11, "b");
        hexSymbol.put(12, "c");
        hexSymbol.put(13, "d");
        hexSymbol.put(14, "e");
        hexSymbol.put(15, "f");

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i<=7; i++) {
            ans.append(hexSymbol.get(num & 15));
            num = num >> 4;
            if(num == 0){
                break;
            }
        }

        StringBuilder hexString = ans.reverse();
        return hexString.toString();

    }
}
