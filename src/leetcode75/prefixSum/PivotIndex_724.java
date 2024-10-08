package leetcode75.prefixSum;

public class PivotIndex_724 {
    public int pivotIndex(int[] nums) {
        // create an array to store the sum of left elements
        int[] preSum = new int[nums.length];
        // store 0 in index 0 because the left elemets of the 0 index will have 0 sum.
        preSum[0] = 0;

        int sum = nums[0];

        for(int i =1; i < nums.length; i++) {
            sum += nums[i];
            preSum[i] = preSum[i-1] + nums[i-1];
        }

        for(int i =0; i < nums.length; i++) {
            if(preSum[i] == sum-nums[i]-preSum[i])
                return i;
        }
        return -1;
    }
}
