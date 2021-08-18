package intervwPrep;
/*
 * ketnakhalasi created on 8/17/21
 * */

import java.util.Stack;

public class MaxHistogramAreaUsingStack {

    public static void main(String[] args) {
        int[] histogram = {4, 2, 8, 6, 5, 3};
        int maxArea = maxAreaUsingStack(histogram);
        System.out.println("Max Area: " + maxArea);
    }

    /* Given a histogram as a diagram of bars where the area is proportional to
 the frequency of a certain variable. i. e there are 6 bars whose widths are
 equal to 1 and heights are 4, 2 8, 6, 5 and 3. write a code snippet that
 computes the largest rectangular area in the histogram.
 */
    public static int maxAreaUsingStack(int[] histogram) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int bar = 0; bar <= histogram.length; bar++) {
            int barHeight;
            if(bar == histogram.length) {
                barHeight = 0; // take into account last bar
            } else {
                barHeight = histogram[bar];
            }

            while(!stack.empty() && barHeight < histogram[stack.peek()]) {
                //we found the bar smaller than the one from the stack
                int top = stack.pop();

                //find the left boundary
                int left = stack.isEmpty() ? -1 : stack.peek();

                //find the width of the rectangular area
                int areaRectWidth = bar - left - 1;

                //compute the area of the current rectangle
                int area = areaRectWidth * histogram[top];
                maxArea = Integer.max(area, maxArea);
            }
            //add the current bar (index) into the stack
            stack.push(bar);
        }
        return maxArea;
    }
}
