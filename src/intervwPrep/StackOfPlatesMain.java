package intervwPrep;
/*
 * ketnakhalasi created on 8/14/21
 * */

public class StackOfPlatesMain {
    public static void main(String[] args) {
        StackOfPlates stack = new StackOfPlates();
        stack.push(25);
        stack.push(35);
        stack.push(15);
        stack.push(-1);
        stack.push(-3);
        stack.push(6);
        stack.push(2);
        stack.push(12);

        stack.printStacks();
        System.out.println("\n\nPop from stack 1: " + stack.popAt(1));
        stack.printStacks();
        System.out.println("\n\nPop from stack 0: " + stack.popAt(0));
        stack.printStacks();
    }
}
