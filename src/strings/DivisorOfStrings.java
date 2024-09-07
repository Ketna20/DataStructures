package strings;

/**
 * For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
 *
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 *
 *
 *
 * Example 1:
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * Example 2:
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 */
public class DivisorOfStrings {

    public static void main(String[] args) {
        String s = gcdOfStrings("LEET", "CODE");
        System.out.println("s : " + s);
    }

    public static String gcdOfStrings(String str1, String str2) {
        // check length for both strings
        int str1Length = str1.length(), str2Length = str2.length();
        // find the shorter string and use it as base string
        for (int i = Math.min(str1Length, str2Length); i >= 1; --i) {
            if (valid(str1, str2, i)) {
                return str1.substring(0, i);
            }
        }
        return "";
    }

    public static boolean valid(String str1, String str2, int k) {
        int str1Length = str1.length(), str2Length = str2.length();
        // check if both strings are made up of multiple of the base string
        if (str1Length % k > 0 || str2Length % k > 0) {
            return false;
        } else {
            String base = str1.substring(0, k);
            return str1.replace(base, "").isEmpty() && str2.replace(base, "").isEmpty();
        }
    }
}
