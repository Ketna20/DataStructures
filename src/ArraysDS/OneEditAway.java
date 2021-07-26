package ArraysDS;
/*
 * ketnakhalasi created on 7/26/21
 * */

public class OneEditAway {
    public static void main(String[] args) {
        System.out.println("One Edit Away");
        boolean oneEditAway = isOneEditAway("tink", "kank");
        System.out.println(oneEditAway);
    }

    public static boolean isOneEditAway(String p, String q) {
        if(p == null || q == null ||
           p.isEmpty() || q.isEmpty()) {
            return false;
        }

        if(Math.abs(p.length() - q.length()) > 1) {
            System.out.println("both strings are more than one character different.");
            return false;
        }

        String shorter = p.length() < q.length() ? p : q;
        String longer =  p.length() > q.length() ? p : q;

        int shortIndex = 0;
        int longIndex = 0;
        boolean marker = false;
        while(shortIndex < shorter.length() && longIndex < longer.length()){
            if(shorter.charAt(shortIndex) != longer.charAt(longIndex)) {
                if(marker){
                    return false;
                }
                marker = true;
                if(shorter.length() == longer.length()){
                    shortIndex++;
                }

            }else {
                shortIndex++;
            }
            longIndex++;
        }
      return true;
    }
}
