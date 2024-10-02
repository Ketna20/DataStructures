package ik.learn.sorting;

public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = {3,6,2,7,9,1};
        printArray(nums);
        insertionSort(nums);
        System.out.println("Sorted");
        printArray(nums);
    }

    public static void printArray(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    public static void insertionSort(int[] nums) {
        int n = nums.length;

        for(int i=1; i<n; i++) {
            int curr = nums[i];
            int j = i-1;
            while (j >= 0 && nums[j] > curr) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = curr;
        }
    }
}
