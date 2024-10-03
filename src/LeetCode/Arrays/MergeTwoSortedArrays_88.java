package LeetCode.Arrays;

public class MergeTwoSortedArrays_88 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);
        printArray(nums1);
    }

    public static void printArray(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void merge(int[] a, int m, int[] b, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int i = m+n-1;

        while(p2 >= 0) {
            if(p1>=0 && a[p1] > b[p2]) {
                a[i--] = a[p1--];
            } else
                a[i--] = b[p2--];
        }
    }
}
