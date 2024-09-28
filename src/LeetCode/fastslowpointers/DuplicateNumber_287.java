package LeetCode.fastslowpointers;

public class DuplicateNumber_287 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 4, 2};
        int duplicate = findDuplicate(nums);
        System.out.println("duplicate: " + duplicate);
    }

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // it is for sure that one duplicate is there
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        // find the head of the loop
        fast = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
