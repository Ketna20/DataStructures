package ik.learn.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible
 * subsets
 *  (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * All the numbers of nums are unique.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class SubsetsLeetcode78 {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        List<List<Integer>> result = subsets(nums);
        for(List<Integer> list : result) {
            System.out.print("[");
            for(int k : list) {
                System.out.print(k + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> slate = new ArrayList<>();
        permuteHelper(nums, slate, 0, result); //working
//        helper(nums, 0, slate, result); // working
        return result;
    }

    public static void permuteHelper(int[] nums, List<Integer> slate, int index, List<List<Integer>> result) {
        //base case
        if(index == nums.length-1) {
            result.add(slate);
            List<Integer> slate1 = new ArrayList<>(slate);
            slate1.add(nums[index]);
            result.add(slate1);
            return;
        }

        // recursive case
        //exclude
        permuteHelper(nums, slate, index+1, result);

        //include
        List<Integer> slate1 = new ArrayList<>(slate);
        slate1.add(nums[index]);
        permuteHelper(nums, slate1, index+1, result);
//        slate.remove(slate.size()-1);
    }

    public static void helper(int[] nums, int index, List<Integer> prev, List<List<Integer>> result){
        if(index == nums.length-1){
            result.add(prev);
            List<Integer> nprev = new ArrayList<>(prev);
            nprev.add(nums[index]);
            result.add(nprev);
            return;
        }
        helper(nums,index+1,prev,result);
        List<Integer> nprev = new ArrayList<>(prev);
        nprev.add(nums[index]);
        helper(nums,index+1,nprev,result);
    }
}
