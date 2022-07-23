package ik.learn.stack;
/*
 * ketnakhalasi created on 7/23/22
 * */
import java.util.Stack;
public class ReversePolishNotation {

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        int exp = evalRPN(tokens);
        System.out.println("Expression: " + exp);
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<tokens.length; i++) {
            if(tokens[i] == "+") {
                stack.push(stack.pop() + stack.pop());
            } else if(tokens[i] == "-") {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            } else if(tokens[i] == "*") {
                stack.push(stack.pop() * stack.pop());
            } else if (tokens[i] == "/") {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }

        return stack.pop();
    }
}
