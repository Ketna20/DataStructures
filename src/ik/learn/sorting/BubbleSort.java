package ik.learn.sorting;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {4, 6, 2, 3, 5};
        int[] numsSorted = bubbleSort(nums);
        printArray(numsSorted);
    }

    public static void printArray(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int[] bubbleSort(int[] nums) {
        int n = nums.length;
        for(int i = 0; i<n; i++) {
            for(int m=n-1; m > i; m--) {
                if(nums[m] < nums[m-1]) {
                    int temp = nums[m];
                    nums[m] = nums[m-1];
                    nums[m-1] = temp;
                }
            }
        }

        return nums;
    }
}
