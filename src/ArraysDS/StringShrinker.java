package ArraysDS;
/*
 * ketnakhalasi created on 7/26/21
 * */

public class StringShrinker {
 /* The given string is abbb vvvv s rttt rr eeee f.
    The expected result will be a1b3 v4 s1 r1t3 r2 e4 f1.
    If the resulting string is not shorter than the given string, then return the given string.
  */
    public static void main(String[] args) {
        String t = "abbb vvvv s rttt rr eeee f";
        System.out.println("Initial String: " + t);
        System.out.println(t.charAt(25));
        System.out.println("Result : " + shrinkString(t));
    }

    public static String shrinkString(String s) {
        StringBuilder result = new StringBuilder();
        int counter = 0;
        for(int i=0; i < s.length(); i++) {
             counter++;

            if(!Character.isWhitespace(s.charAt(i))){

                if ((i+1) < s.length()
                  && s.charAt(i) != s.charAt(i+1)) {
                    result.append(s.charAt(i)).append(counter);
                    counter = 0;
                }

            }else {
                //if space character then append ans set counter
                result.append(s.charAt(i));
                counter = 0;
            }
        }
        //return result.toString();
        //return only the shorter string
        return result.length() < s.length() ? result.toString() : s;
    }

}
