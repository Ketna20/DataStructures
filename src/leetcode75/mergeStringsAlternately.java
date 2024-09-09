package leetcode75;

/**
 * You are given two strings word1 and word2.
 * Merge the strings by adding letters in alternating order,
 * starting with word1. If a string is longer than the other,
 * append the additional letters onto the end of the merged string.
 *
 * Return the merged string.
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 */
public class mergeStringsAlternately {

    public static void main(String[] args) {
        String s = mergeAlternately("abc", "pqrstu");
        System.out.println("Merged String: " + s);
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder mergedString = new StringBuilder();
        int i=0;
        int j=0;
        while(i < word1.length() && j < word2.length()) {
            mergedString.append(word1.charAt(i++));
            mergedString.append(word2.charAt(j++));
        }
        if(i<word1.length()) {
            mergedString.append(word1.substring(i));
        }
        if(j<word2.length()) {
            mergedString.append(word2.substring(j));
        }

        return mergedString.toString();
    }
}
