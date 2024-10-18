package leetcode75.stack;

import java.util.Stack;

public class RemoveStarts_2390 {
    public static void main(String[] args) {

    }

    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();

        int n = ch.length;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            if(ch[i] == '*') {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch[i]);
            }

        }
        System.out.println("Stack (direct print): " + stack);

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

}
