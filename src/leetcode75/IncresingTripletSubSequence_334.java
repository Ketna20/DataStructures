package leetcode75;

/**
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5]
 * Output: true
 * Explanation: Any triplet where i < j < k is valid.
 * Example 2:
 *
 * Input: nums = [5,4,3,2,1]
 * Output: false
 * Explanation: No triplet exists.
 * Example 3:
 *
 * Input: nums = [2,1,5,0,4,6]
 * Output: true
 * Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 *
 * Approach:
 * Let’s use the array [20,100,10,12,5,13].
 *
 * Initialization:
 *
 * i is initialized to infinity.
 * j is also initialized to infinity.
 *   num = 20
 *      20 <= i (infinity), so i = 20
 *          Current state: i = 20, j = infinity.
 *
 *   num = 100
 *      100 <= j (infinity), so j = 100.
 *          Current state: i = 20, j = 100.
 *
 *   num = 10
 *     10 < i(20)
 *       Current state: i = 10, j = 100.
 *   num = 12
 *     12 < j(100)
 *       Current state: i = 10, j = 12.
 *
 *    num = 5
 *      5 < i(10)
 *        Current state: i = 5, j = 12.
 *    num = 13
 *     not 13 < i(5) and not 13 < j(12) - so goes in else -> returns true
 *
 * The function returns True for 12 < 5 < 13
 */
public class IncresingTripletSubSequence_334 {

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;

        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;

        for(int num : nums) {
            if(num <= i) {
                i = num;
            } else if(num <= j) {
                j = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
