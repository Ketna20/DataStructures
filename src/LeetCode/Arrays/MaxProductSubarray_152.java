package LeetCode.Arrays;

/**
 * Given an integer array nums, find a
 * subarray
 *  that has the largest product, and return the product.
 *
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 * Example 1:
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Example 2:
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaxProductSubarray_152 {
// variation of Selection Sort
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums)); // 6 - {2,3}

        int[] nums1 = {-2,0,-1};
        System.out.println(maxProduct(nums1));

        int[] nums2 = {2,3,-2, -5, 6, -1, 4};
        System.out.println(maxProduct(nums2)); // 360 - {{2,3,-2, -5, 6}
    }

    public static int maxProduct(int[] nums) {
        // Two pointer approach
        int len = nums.length;
        int left = 1;
        int right = 1;
        int max = nums[0];

        for(int i=0; i<len; i++) {
            left = left == 0 ? 1 : left;
            right = right == 0 ? 1 : right;

            left *= nums[i];
            right *= nums[len-1-i];

            max = Math.max(max, Math.max(left, right));
        }

        return max;
    }
}
