package intervwPrep;

import java.util.Stack;

/*
 * ketna khalasi created on 8/17/21
 * */
/*
 A String representing a number of n digits. Write a snippet of code that prints
 the smallest possible number after removing the given K digits.
 */
public class SmallestNumber {

    public static void main(String[] args) {
        String number = "4321";
        smallestAfterRemove(number, 2);
    }

    public static void smallestAfterRemove(String number, int k) {
        if(number == null || k <= 0 || k >= number.length()) {
            System.out.println("The number is: " + 0);
            return;
        }
         int i=0;
        Stack<Character> charStack = new Stack<>();
        while(i < number.length()) {
            //if the current digit is less than the previous
            // digit then discard the previous one
            while(k > 0 && !charStack.isEmpty()
                    && charStack.peek() > number.charAt(i)) {
                charStack.pop();
                k--;
            }

            charStack.push(number.charAt(i));
            i++;
        }

        //cover corner cases such as '22222'
        while(k > 0) {
            charStack.pop();
            k--;
        }

        System.out.println("The number is (as a printed stack; ignore leading 0s (if any)): " + charStack);
    }
}
