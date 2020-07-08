package stacks;
/*
 * ketnakhalasi created on 7/8/20
 * */

public class Stack {
    static final int max = 10;
    int top;
    int s[] = new int[max];

    public Stack() {
        top = -1;
    }

    public boolean isEmpty() {
        return (top < 0);
    }

    public boolean push(int i) {
        if(top >= max-1) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            s[++top] = i;
            System.out.println(i + " pushed into stack.");
            return true;
        }
    }

    public int pop() {
        if (top < 0) {
            System.out.println("Stack underflow");
            return 0;
        } else {
            return s[top--];
        }
    }

    public int peek() {
        if (top < 0) {
            System.out.println("Stack underflow");
            return 0;
        } else {
            return s[top];
        }
    }
}
