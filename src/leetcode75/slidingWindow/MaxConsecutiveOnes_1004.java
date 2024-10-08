package leetcode75.slidingWindow;

public class MaxConsecutiveOnes_1004 {

    public int longestOnes(int[] nums, int k) {
        int res = 0;

        int i=0;
        int j = -1;
        int countOfZeroesInWindow = 0;

         while (i < nums.length) {
             //acquire
             if(nums[i] == 0) {
                 countOfZeroesInWindow++;
             }
             i++;
             //if invalid, release j till valid again (valid: zeroes <= k)
             while(countOfZeroesInWindow > k) {
                 j++;
                 if(nums[j] == 0) {
                     countOfZeroesInWindow--;
                 }
             }
             // consider
             int windowSize = i-1-j;
             res = Math.max(res, windowSize);
         }
         return res;
    }
}
