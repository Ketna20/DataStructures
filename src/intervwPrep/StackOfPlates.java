package intervwPrep;
/*
 * ketnakhalasi created on 8/14/21
 * */

import LinkedList.LinkedList;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackOfPlates {
    private static final int STACK_SIZE = 3;
    private LinkedList<Stack<Integer>> stacks = new LinkedList<Stack<Integer>>();

    public void push(int value) {
        // if there is no stack or the last stack is full
        if(stacks.isEmpty() || stacks.getLast().size() >= STACK_SIZE) {
            //create a new stack and push the value in it
            Stack<Integer> newStack = new Stack<>();
            newStack.push(value);

            //add the new STack in the list of stacks
            stacks.addLast(newStack);
        } else {
            //add the value in the last stack
            stacks.getLast().push(value);
        }
    }

    public Integer pop() {
        if(stacks.isEmpty()) {
            throw new EmptyStackException();
        }
        //find the last stack
        Stack<Integer> lastStack = stacks.getLast();
        int value = lastStack.pop();
        //if last stack is empty then remove it from list of stacks
        removeStackIfEmpty();
        return value;
    }

    private void removeStackIfEmpty() {
        if(stacks.getLast().isEmpty()) {
            stacks.remove(stacks.getLast());
        }
    }

    public Integer popAt(int stackIndex) {
        if(stacks.isEmpty()) {
            throw new EmptyStackException();
        }
        if(stackIndex < 0 || stackIndex >= stacks.getLength()) {
            throw new IllegalArgumentException("The given index is out of bounds.");
        }

        //get the value from the corresponding stack
        int value = stacks.get(stackIndex).pop();

        //since we pop an element we must shift the remaining elements
        shift(stackIndex);

        //if last stack is empty we can remove it from the list of stacks
        removeStackIfEmpty();

        return value;
    }

    private void shift(int index) {
        for(int i=index; i< stacks.getLength()-1; ++i) {
            Stack<Integer> currentStack = stacks.get(i);
            Stack<Integer> nextStack = stacks.get(i+1);

            currentStack.push(nextStack.remove(0));
        }

    }

    public void printStacks() {
        for(int i=0; i < stacks.getLength(); i++) {
            System.out.println("\nStack " + (i) + ": " );
            System.out.println("BOTTOM -> ");
            for(int value : stacks.get(i)) {
                System.out.println(value + " ");
            }
            System.out.println(" <- Top\n");
        }
    }
}
