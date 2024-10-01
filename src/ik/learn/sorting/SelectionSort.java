package ik.learn.sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {4, 6, 2, 3, 5};
        System.out.println("Unsorted Array");
        printArray(nums);

        int[] numsSorted = selectionSort(nums);
        System.out.println("Sorted Array");
        printArray(numsSorted);

    }

    public static void printArray(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int[] selectionSort(int[] nums) {
        int n = nums.length;

        for(int i = 0; i<n; i++) {
            int minElementIndex = i;
            int minElement = nums[i];

            for(int m=i+1; m<n; m++) {
                if(nums[m] < minElement) {
                    minElement = nums[m];
                    minElementIndex = m;
                }
            }
            // swap the minElement
            int temp = nums[i];
            nums[i] = nums[minElementIndex];
            nums[minElementIndex] = temp;
        }
        return nums;
    }
}
