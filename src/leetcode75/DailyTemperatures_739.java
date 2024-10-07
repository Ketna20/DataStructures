package leetcode75;

import java.util.Stack;
public class DailyTemperatures_739 {

    public static void main(String[] args) {
        int[] temps = {73,74,75,71,69,72,76,73};
        int[] res = dailyTemperatures(temps);
        printArray(res);
    }


    public static void printArray(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    public static int[] dailyTemperatures(int[] temps) {
        int n = temps.length;

        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && temps[i] > temps[stack.peek()]) {
                int index = stack.pop();
                res[index] = i -index;
            }
            stack.push(i);
        }
        return res;
    }
}
