package intervwPrep;
/*
 * ketnakhalasi created on 8/12/21
 * */

import java.util.Stack;
/* Reverse String using Stack
  1.Loop String from left to right and push each character into a stack
  2.Loop the stack and pop each character and put back in the String.
*/
public class ReverseStringUsingStack {
    public static void main(String[] args) {
        String str = "dlrow olleh";
        String result = reverseString(str);
        System.out.println("Original String: " + str );
        System.out.println( "Reversed String: " + result);
    }

    public static String reverseString(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        //push character of string into stack
        for(char c : chars) {
            stack.push(c);
        }
        //pop each character from stack and put back in the String
        for(int i=0; i<s.length(); i++) {
            chars[i] = stack.pop();
        }
        //return the string
        return new String(chars);
    }
}
