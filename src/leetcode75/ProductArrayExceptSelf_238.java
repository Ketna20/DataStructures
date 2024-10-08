package leetcode75;

import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 * Approach
 * Key Insight: No Division Allowed
 * Normally, if division was allowed, the problem would be straightforward: we could multiply all elements together and then divide by the current element to get the product for each index. But since division is prohibited, we need a different approach.
 *
 * Breaking the Problem into Two Halves:
 * Instead of calculating the entire product except for one element at a time, we can split this problem into two sub-problems:
 *
 * Left Product: For each element, calculate the product of all elements to its left.
 * Right Product: For each element, calculate the product of all elements to its right.
 * By combining these two products (left and right), we get the desired result.
 *
 * Two Passes:
 * Left-to-right pass: For each element, compute the cumulative product of elements to the left. Store this in the output array. Initially, this product is 1 (since there are no elements to the left of the first element).
 * Right-to-left pass: Similarly, we can compute the cumulative product of elements to the right in a second pass. Again, the initial product starts as 1 for the rightmost element.
 * For an array nums = [1, 2, 3, 4]:
 *
 * Left pass:
 * Before traversal: output = [1, 1, 1, 1]
 * After 1st element: output = [1, 1, 1, 1] (left product of first element is 1)
 * After 2nd element: output = [1, 1, 1, 1] (left product of second element is 1 * 1)
 * After 3rd element: output = [1, 1, 2, 1] (left product of third element is 1 * 2)
 * After 4th element: output = [1, 1, 2, 6] (left product of fourth element is 1 * 2 * 3)
 *
 * Right pass:
 * Before traversal: right = 1
 * After 4th element: output = [1, 1, 2, 6] (right product of fourth element is 1)
 * After 3rd element: output = [1, 1, 8, 6] (right product of third element is 1 * 4)
 * After 2nd element: output = [1, 12, 8, 6] (right product of second element is 1 * 4 * 3)
 * After 1st element: output = [24, 12, 8, 6] (right product of first element is 1 * 4 * 3 * 2)
 * So the final output is [24, 12, 8, 6].
 *
 * Complexity
 * Time complexity: O(n) – we make two passes through the array.
 * Space complexity: O(1) (excluding the output array), as we only use a few variables (left, right).
 */
public class ProductArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];

        Arrays.fill(res, 1);

        int curr = 1;
        for(int i=0; i<n; i++) {
            res[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for(int i=n-1; i>=0; i--) {
            res[i] *= curr;
            curr *= nums[i];
        }
        return res;
    }
}
