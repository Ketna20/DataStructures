package leetcode75.slidingWindow;

import java.util.Arrays;
import java.util.List;

public class MaxVowelsSubString_1456 {

    public int maxVowels(String s, int k) {
        int res = 0;
        int count = 0;

        for(int i=0; i<k; i++) {
            char c = s.charAt(i);
            if(isVowel(c)) {
                count++;
            }
        }
        res = count;

        for(int i=k; i<s.length(); i++) {
            char ch = s.charAt(i);
            char chMinusK = s.charAt(i-k);

            if(isVowel(ch)) {
                count++;
            }

            if(isVowel(chMinusK)) {
                count--;
            }

            res = Math.max(res, count);
        }
        return res;
    }

    public boolean isVowel(char c) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        return vowels.contains(c);
    }
}
