package LeetCode.Arrays;

import java.util.Arrays;

public class SortAnArray_912 {

    public static void main(String[] args) {

    }
    // Merge Sort
    public static int[] sortArray(int[] nums) {
        int n = nums.length;

        if(n==1) return nums;

        int[] left = Arrays.copyOfRange(nums, 0, n/2);
        int[] right = Arrays.copyOfRange(nums, n/2, n);

        left = sortArray(left);
        right = sortArray(right);

        return merge(nums, left, right);
    }

    public static int[] merge(int[] nums, int[] left, int[] right) {
        int i=0;
        int j=0;
        int k=0;

        while(i < left.length && j < right.length) {
            if(left[i] < right[j]) {
                nums[k++] = left[i];
                i++;
            } else {
                nums[k++] = right[j];
                j++;
            }
        }
        while(i<left.length) {
            nums[k++] = left[i];
            i++;
        }
        while(j<right.length) {
            nums[k++] = right[j];
            j++;
        }
        return nums;
    }
}
