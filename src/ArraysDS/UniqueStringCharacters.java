package ArraysDS;
/*
 * ketnakhalasi created on 7/25/21
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UniqueStringCharacters {
    public static void main(String[] args) {
        String s = "java";
        String duplicate = "";
        List<Character> chars = new ArrayList<>();
        char[] c = s.toCharArray();
        for (char c1 : c) {
            if(!chars.contains(c1)) {
                chars.add(c1);
            } else {
                duplicate += c1 + " ";
            }
        }
        System.out.println("duplicate :" + duplicate);
    }
}
