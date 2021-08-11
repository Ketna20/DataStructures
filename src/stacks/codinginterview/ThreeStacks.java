package stacks.codinginterview;
/*
 * ketnakhalasi created on 8/10/21
 * */

import stacks.codinginterview.exceptions.OverflowException;
import stacks.codinginterview.exceptions.UnderflowException;

public class ThreeStacks {
    private static final int NO_OF_STACKS = 3;

    private final int stackCapacity;
    private final int[] values;
    private final int[] stacks;

    public ThreeStacks(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * NO_OF_STACKS];
        stacks = new int[NO_OF_STACKS];
    }

    public void push(int stackNumber, int value) throws OverflowException {
        if(isFull(stackNumber)) {
            throw new OverflowException("Stack Overflow.");
        }
        //increment stack pointer and then update the top value
        stacks[stackNumber]++;
        values[fetchTopIndex(stackNumber)]= value;
    }

    private int fetchTopIndex(int stackNumber) {
        int offset = stackNumber * stackCapacity;
        int size = stacks[stackNumber];
        return offset + size - 1;
    }

    public boolean isEmpty(int stackNumber) {
        return stacks[stackNumber] == 0;
    }

    private boolean isFull(int stackNumber) {
        return stacks[stackNumber] == stackCapacity;
    }

    public int pop(int stackNumber) throws UnderflowException {
        if(isEmpty(stackNumber)) {
            throw new UnderflowException("Stack Underflow...");
        }
        int topIndex = fetchTopIndex(stackNumber);
        int value = values[topIndex];

        values[topIndex] = 0;
        stacks[stackNumber]--;

        return value;
    }

    public int peek(int stackNumber) throws UnderflowException {
        if(isEmpty(stackNumber)) {
            throw new UnderflowException("Stack Underflow...");
        }

        return values[fetchTopIndex(stackNumber)];
    }

    public void printStacks() {
        for(int i=0; i< NO_OF_STACKS; i++) {
            System.out.println("\nStack number: " + (i+1));
            if(!isEmpty(i)) {
                int topIndex = fetchTopIndex(i);
                while(values[topIndex] != 0 && topIndex > 0) {
                    System.out.println(values[topIndex]);
                    topIndex--;
                }
            } else {
                System.out.println("\nStack Number: " + (i+1) + " is empty!");
            }
        }
    }
}
