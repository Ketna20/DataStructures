package strings;
/*
 * ketnakhalasi created on 7/19/22
 * */

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] args) {
        boolean isValidAnagram = isAnagram("anagram", "nagaram");
        boolean isValidAnagram1 = isAnagramUsingHashmap("care", "rac");
        System.out.println(isValidAnagram);
        System.out.println(isValidAnagram1);
    }

    public static boolean isAnagramUsingHashmap(String s, String t){
        if (s.length() != t.length()) return false;
        Map<Character, Integer> chars = new HashMap<>();

        for (Character c: s.toCharArray()) {
            chars.put(c, chars.getOrDefault(c, 0) + 1);
        }
        for (Character c: t.toCharArray()) {
            chars.put(c, chars.getOrDefault(c, 0) - 1);
        }

        for(int num : chars.values()) {
            if(num != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] store = new int[26];

        for(int i=0; i<s.length(); i++) {
            System.out.println("s.charAt(i: " + s.charAt(i));
            System.out.println("store[s.charAt(i) - 'a']: " + store[s.charAt(i) - 'a']);
            store[s.charAt(i) - 'a']++;
            System.out.println("t.charAt(i: " + t.charAt(i));
            System.out.println("store[t.charAt(i) - 'a']: " + store[t.charAt(i) - 'a']);
            store[t.charAt(i) - 'a']--;

        }

        for(int n : store) {
            if(n != 0)
                return false;
        }

        return true;
    }
}
