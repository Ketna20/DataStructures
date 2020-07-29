package intervwPrep;
/*
 * ketnakhalasi created on 7/16/20
 * */

public class RepeatedStrings {

    public static void main(String[] args) {
        String s = "aba";
        long n = 10;
        long len = n / s.length();
        System.out.println("len: " + len);
        System.out.println(repeatedString(s, n));
    }

    static long repeatedString(String s, long n) {
        char[] c = s.toCharArray();
        long repeated = 0;
        int strLength = c.length;
        for(char a : c) {
            if (a == 'a') {
                repeated++;
            }
        }
        return repeated;
    }
}
