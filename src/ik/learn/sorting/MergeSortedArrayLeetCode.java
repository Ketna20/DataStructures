package ik.learn.sorting;


// LeetCode: 88
public class MergeSortedArrayLeetCode {

    public static void main(String[] args) {
        int[]  nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5,6};
        int m = 3; int n=3;
        merge(nums1, m, nums2, n);
        for(int i: nums1) {
            System.out.println(i);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int resultP = nums1.length - 1;

        while(resultP >= 0) {
            if(p2 < 0 || (p1 >= 0 && nums1[p1] >= nums2[p2])) {
                nums1[resultP] = nums1[p1--];
            } else {
                nums1[resultP] = nums2[p2--];
            }

            resultP--;
        }
    }
}
