package ik.learn.binarySearch;
/*
 * ketnakhalasi created on 9/4/22
 * */

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
//        int[] nums1 = {1, 2};
//        int[] nums2 = {3, 4};
        int[] nums1 = {100000};
        int[] nums2 = {100001};
//        double median = findMedianSortedArrays(nums1, nums2);
//        System.out.println("median: " + median);
        System.out.println((100000+100001)/2.0);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m= nums1.length;
        int n = nums2.length;
        int k = 0;
        if((m+n) % 2 == 1) {
            k = ((m+n)/2) +1;
        } else {
            k = (m+n)/2;
        }
        int start = 0;
        int end = m-1;
        double kthSmallest = 0;
        double succ = 0;
        while(start <= end) {
            int mid = start + (end-start)/2;
            // if nums1[mid] is kth smallest element
            if((get(nums2, k-1-mid-1) <= get(nums1, mid)) && (get(nums1, mid) <= get(nums2, k-1-mid))) {
                kthSmallest = get(nums1, mid);
                succ = Math.min(get(nums1, mid+1), get(nums2, k-1-mid));
                break;
            }
            // if kth smallest element is in left zone
            else if(get(nums2, k-1-mid) < get(nums1, mid)) {
                end = mid - 1;
            }
            //if kth smallest element is in right zone get(nums2, k-1-mid-1)>get(nums1, mid)
            else {
                start = mid+1;
            }
        }
        //kth smallest element not found in nums1
        if(start == end+1) {
            kthSmallest = get(nums2, k-1-start);
            succ = Math.min(get(nums1, start), get(nums2, k-start));
        }

        if((m+n) % 2 == 1) {
            return kthSmallest;
        } else {
            return (kthSmallest + succ)/2.0;
        }
    }

    public static int get(int[] a, int i) {
        if(i<0)
            return -123;
        else if(i >= a.length) {
            return 123;
        } else {
            return a[i];
        }
    }
}
