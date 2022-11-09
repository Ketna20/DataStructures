package ik.learn.sorting;

/*
*  Given integer array, return all triplets nums[i], nums[j], and nums[k],
* such that their sum = 0;
* Ex: [-1, 0, 1, 2,-1, -4] output : [-1,0,1], [-1,-1,2]
* Ex: [0, 1, 1] output : []
* Ex: [0, 0, 0] output: [0,0,0]
* */

import java.util.*;

public class ThreeSum {


    public static void main(String[] args) {
        int[] nums = new int[] {-1, 0, 1, 2,-1, -4};
        List<List<Integer>> res =  threeSum(nums);
        for(List<Integer> i : res) {
            System.out.print("[");
            for(Integer k : i) {
                System.out.print(k + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> a = new HashSet<>();
        int target = 0;
        Arrays.sort(nums);
        List<Integer> c;
        int n = nums.length;
        for(int i=0; i<n-2; i++) {
            int l=i+1;
            int r= n-1;
            while( l < r){
                int s= nums[i] + nums[l] + nums[r];
                int diff = target - s;

                if(diff == 0) {
                    c = Arrays.asList(nums[i], nums[l], nums[r]);
                    Collections.sort(c);
                    a.add(c);
                }
                if(s > target) {
                    r--;
                } else{
                    l++;
                }
            }
        }
        List<List<Integer>> res =new ArrayList<>();
        res.addAll(a);
        return res;
    }
}
