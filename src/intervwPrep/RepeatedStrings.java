package intervwPrep;
/*
 * ketnakhalasi created on 7/16/20
 * */

public class RepeatedStrings {

    public static void main(String[] args) {
        String s = "aba";
        long n = 10;
        System.out.println(repeatedString(s, n));
    }
    public static long repeatedString(String s, long n) {
        long numOfReps = n/s.length();
        long remainder = n%s.length();
        long repeated = 0;
        for (int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'a'){
                repeated++;
            }
        }
        repeated = repeated * numOfReps;
        for (int i=0; i<remainder; i++) {
            if(s.charAt(i) == 'a') {
                repeated++;
            }
        }
        return repeated;
    }


}
