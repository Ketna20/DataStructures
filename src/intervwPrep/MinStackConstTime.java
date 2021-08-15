package intervwPrep;
/*
 * ketnakhalasi created on 8/15/21
 * */

import java.util.Stack;

public class MinStackConstTime extends Stack<Integer> {
    Stack<Integer> stackOfMin;

    public MinStackConstTime(){
        stackOfMin = new Stack<>();
    }

    public Integer push(int value) {
        if(value <= min()) {
            stackOfMin.push(value);
        }
        return super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if(value == min()) {
            stackOfMin.pop();
        }
        return value;
    }

    public int min() {
        if(stackOfMin.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return stackOfMin.peek();
        }

    }
}
