package leetcode75.slidingWindow;

public class LongestSubarrayOfOnes_1493 {
    public int longestSubarray(int[] nums) {
        int res = 0;

        int i = 0;
        int j = -1;
        int count = 0;
        //acquire
        while (i<nums.length) {
            if(nums[i] == 0) {
                count++;
            }
            i++;

            // if invalid, release till valid
            while (count > 1 && j < i) {
                j++;
                if(nums[j] == 0) {
                    count--;
                }
            }
            // consider
            int windowSize = i-1-j;
            res = Math.max(res, windowSize);
        }

        return res - 1;
    }
}
