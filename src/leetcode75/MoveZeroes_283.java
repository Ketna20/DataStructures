package leetcode75;

public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;

        for(int right=0; right<n; right++) {
            if(nums[right] != 0) {
                //swap the nums
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }
}
