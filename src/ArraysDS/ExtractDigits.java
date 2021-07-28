package ArraysDS;
/*
 * ketnakhalasi created on 7/27/21
 * */

import java.util.ArrayList;
import java.util.List;
/*
 Write a snippet of code that extracts integers from this string.
 The given string is cv dd 4 k 2321 2 11 k4k2 66 4d.
 The expected result: 4, 2321, 2, 11, 4, 2, 66, and 4.
 */
public class ExtractDigits {
    public static void main(String[] args) {
        String str = "cv dd 4 k 2321 2 11 k4k2 66 4d";
        System.out.println("String: " + str);

        List<Integer> digits = extractDigit(str);
        System.out.println("Integers : " + digits);
     //   digits.stream().forEach((d) -> System.out.println(d));


    }

    public static List<Integer> extractDigit(String s) {
        List<Integer> digitList = new ArrayList<>();
        StringBuilder temp = new StringBuilder(
                String.valueOf(Integer.MAX_VALUE).length());
            for(int i=0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if(Character.isDigit(ch)) {
                    temp.append(ch);
                } else {
                    if(temp.length() > 0) {
                        digitList.add(Integer.parseInt(temp.toString()));
                        temp.delete(0, temp.length());
                    }
                }
            }

        return digitList;
    }


}
