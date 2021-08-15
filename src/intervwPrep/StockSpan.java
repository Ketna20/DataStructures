package intervwPrep;
/*
 * ketnakhalasi created on 8/15/21
 * */

import java.util.Arrays;
import java.util.Stack;
/*
Given array of Stock prices of consecutive days, write a code that returns stock span of those days.
First day of stock span is always 1.
 */
public class StockSpan {

    public static void main(String[] args) {
        int[] stockPrices = {55, 34, 22, 23, 27, 88, 70, 42, 51, 100};
        int[] stockPrices1 = {55, 34, 42, 23, 27, 88, 70, 52, 51, 100};
        int[] spanResult = stockSpan(stockPrices);
        int[] spanResult1 = stockSpan(stockPrices1);

        System.out.println("Stock Prices: " + Arrays.toString(stockPrices));
        System.out.println("Span result: " + Arrays.toString(spanResult));

        System.out.println("Stock Prices: " + Arrays.toString(stockPrices1));
        System.out.println("Span result: " + Arrays.toString(spanResult1));
    }

    public static int[] stockSpan(int[] stockPrices) {
        if(stockPrices == null) {
            throw new IllegalArgumentException("Stock Prices array cannot be null.");
        }

        Stack<Integer> dayStack = new Stack<>();
        int[] spanResult = new int[stockPrices.length];

        spanResult[0] = 1; // first day of span
        dayStack.push(0);

        for(int i=1; i< stockPrices.length; i++) {
            //pop until we find the price on stack that is greater than
            // current day's price or there are no more days left.
            while(!dayStack.empty() && stockPrices[i] > stockPrices[dayStack.peek()]) {
                dayStack.pop();
            }

            // if there is no price greater than the current day's price
            // then the stock span is the number of days.
            if(dayStack.empty()) {
                spanResult[i] = i+1;
            } else {
                // if there is a price greater than the current day's price
                // then the stock span is the difference between the current day and that day
                spanResult[i] = i - dayStack.peek();
            }
            //push the current day on top of the stack
            dayStack.push(i);
        }
        return spanResult;
    }
}
