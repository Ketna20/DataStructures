package strings;
/*
 * ketnakhalasi created on 7/28/21
 * */

public class StringRotation {

    public static void main(String[] args) {
        String s1 = "helloworld";
        String s2 = "orldhellow";
        System.out.println(isRotation(s1, s2));
    }

    public static boolean isRotation(String s1, String s2) {
        if(s1 == null || s1.isEmpty() ||
                s2 == null || s2.isEmpty()) {
            return false;
        }


        if (s1.length() == s2.length()) {
            char firstCharS1 = s1.charAt(0);
            int firstCharIndex = 0;
            int lastIndex = s1.length() -1;

            for(int i=0; i<s2.length(); i++) {
                if(s2.charAt(i) == firstCharS1) {
                    firstCharIndex = i;
                    String p1 = s2.substring(i, 10);
                    String p2 = s2.substring(0, i);
                    String combine = p1 + p2;
                    System.out.println(combine);
                    if(combine.equals(s1)) {
                        return true;
                    }

                }
            }
        }
        return false;
    }



}
