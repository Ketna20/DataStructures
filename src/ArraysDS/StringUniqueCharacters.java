package ArraysDS;
/*
 * ketnakhalasi created on 7/25/21
 * Problem: Consider a string that can contain ASCII and
 * Unicode characters ranging between 0-65,535. Write a
 * snippet of code that returns true if this string contains
 * unique characters. The whitespaces can be ignored.
 * */

import java.util.HashMap;
import java.util.Map;

public class StringUniqueCharacters {
    public static final int MAX_CODE = 65535;

    public static void main(String[] args) {
        String s = "java java";
        boolean b1 = isUnique(s);
        System.out.println("b1 : " + b1);
    }

    public static boolean isUnique(String str) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return false;
        }

        Map<Character, Boolean> chars = new HashMap<>();

        // or use for(char ch: str.toCharArray()) { ... }
        for (int i = 0; i < str.length(); i++) {

            if (str.codePointAt(i) <= MAX_CODE) {
                char ch = str.charAt(i);
                if (!Character.isWhitespace(ch)) {
                    if (chars.put(ch, true) != null) {
                        return false;
                    }
                }
            } else {
                System.out.println("The given string contains unallowed characters");
                return false;
            }
        }

        return true;
    }


}
