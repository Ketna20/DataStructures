package ik.learn.stack;
/*
 * ketnakhalasi created on 7/22/22
 * */

import java.util.ArrayDeque;
import java.util.Deque;
/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false
 */
public class ValidParenthesis {

     public boolean isValid(String s) {
            Deque<Character> stack = new ArrayDeque<>();

            for(Character c : s.toCharArray()) {
                if(c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                    continue;
                }
                if(stack.isEmpty()) return false;

                char check;
                switch(c) {
                    case ')':
                        check = stack.pop();
                        if(check == '{' || check == '[') return false;
                        break;
                    case '}':
                        check = stack.pop();
                        if(check == '(' || check == '[') return false;
                        break;
                    case ']':
                        check = stack.pop();
                        if(check == '{' || check == '(') return false;
                        break;
                }
            }

            return stack.isEmpty();
        }


}
