package intervwPrep;
/*
 * ketnakhalasi created on 8/13/21
 * */

import java.util.Stack;

public class BracesStack {
    public static void main(String[] args) {
        String goodBracesStr = "{}{{{}}}{{}}{}";
        String wrongBracesStr = "{}{{{}}}{{}{{}";
        System.out.println("Good Braces: " + matchingBraces(goodBracesStr));
        System.out.println("Mismatched Braces: " + matchingBraces(wrongBracesStr));
    }

    public static boolean matchingBraces(String braces) {
        if (braces == null || braces.isEmpty()) {
            return false;
        }
        Stack<Character> braceStack = new Stack<>();

        int length = braces.length();
        for(int i=0; i<length; i++) {
            switch (braces.charAt(i)) {
                case '{':
                    braceStack.push(braces.charAt(i));
                    break;
                case '}':
                    if(braceStack.isEmpty()) { //found mismatch
                        return false;
                    }
                    braceStack.pop(); // for every match, pop corresponding {
                    break;
                default:
                    return false;
            }
        }
        return braceStack.empty();
    }
}
