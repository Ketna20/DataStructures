package ArraysDS;
/*
 * ketnakhalasi created on 7/28/21
 * */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SurrogatePairs {

    public static void main(String[] args) {
        char[] musicalScore = new char[]{'\uD83C', '\uDFBC'}; // code point: 127932 (57276)

        char[] smileyFace = new char[]{'\uD83D', '\uDE0D'}; // code point: 128525 (56845)

        char[] twoHearts = new char[]{'\uD83D', '\uDC95'}; // code point: 128149 (56469)

        char[] cyrillicZhe = new char[]{'\u04DC'}; // code point: 1244

        String str = "is  " + String.valueOf(cyrillicZhe) + "  zhe"

                + String.valueOf(twoHearts) + "  two hearts  "

                + String.valueOf(smileyFace) + "  smiley face and,  "

                + String.valueOf(musicalScore) + "  musical score";


        List<Integer> result = extract(str);

        System.out.println("The extracted surrogate pairs have the following code points:");
        System.out.println(result);
    }

    public static List<Integer> extract(String str) {

        if (str == null || str.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {

            int cp = str.codePointAt(i);
            if (i < str.length() - 1 && str.codePointCount(i, i + 2) == 1) {
                result.add(cp);
                result.add(str.codePointAt(i+1));
                i++;
            }

         /*
            // or, like this
            int cp = str.codePointAt(i);
            if (Character.charCount(cp) == 2) { // 2 means a suroggate pair
                result.add(cp);
                result.add(str.codePointAt(i+1));
                i++;
            }
         */
        }

        return result;
    }
}
