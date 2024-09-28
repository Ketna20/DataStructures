package LeetCode.fastslowpointers;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 202
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 * Example 1:
 * Input: n = 19
 * Output: true
 * Explanation:
 * (1*1) + (9*9) = 82
 * 8*8 + 2*8 = 68
 * 6*6 + 8*8 = 100
 * 1*1 + 0*0 + 0*0 = 1
 */
public class HappyNumber_202 {

    public static void main(String[] args) {
//        boolean isHappyNumber = isHappy(19);
        System.out.println("is 19 happy number:" + isHappy(19));
        System.out.println("is 2 happy number:" + isHappy(2));

    }

    public static boolean isHappy(int n) {
        if(n == 1 || n == -1) return true;

        Set<Integer> visit = new HashSet<>();

        // compute square until getting duplicate value
        while(!visit.contains(n)) {
            visit.add(n);
            //helper method to compute square
            n = sumOfSquares(n);
            if (n == 1) return true;
        }
        return false;
    }

    public static int sumOfSquares(int n) {
        int sum = 0;

        while (n != 0) {
            int digit = n % 10;
            digit = digit * digit;
            sum += digit;
            n = n / 10;
        }
        return sum;
    }
}
