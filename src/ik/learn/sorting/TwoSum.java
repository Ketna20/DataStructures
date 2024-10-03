package ik.learn.sorting;

public class TwoSum {

    public static void main(String[] args) {
        int[] a = new int[] {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSumForSorted(a, target);
        printArray(res);
        System.out.println();
        int[] a1 = new int[] {3, 5, 34, 17, 20, 9};
        int target1 = 25;

        int[] res1 = twoSumForNotSorted(a1, target1);
        printArray(res1);
    }


    public static void printArray(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    // if the array is sorted
    public static int[] twoSumForSorted(int[] a, int target) {
        int i=0;
        int j=a.length -1;

        while(a[i] + a[j] != target) {
             if(a[i] + a[j] > target) {
                 j--;
             } else {
                 i++;
             }
        }
        return new int[] {i, j};
    }

    // if the array is not sorted
    public static int[] twoSumForNotSorted(int[] a, int target) {
        int n = a.length;
        if(n > 2) {
            for(int i=0; i<n; i++) {
                for(int k=i+1; k<n; k++) {
                    if(a[i] + a[k] == target) {
                        return new int[] {i,k};
                    }
                }
            }
        }
        return new int[] {0,1};
    }
}
