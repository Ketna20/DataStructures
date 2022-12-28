package ik.learn.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Input: [4,4,4,1,4]
 *
 * output:
 * [[],[1],[1,4],[1,4,4],[1,4,4,4],[1,4,4,4,4],[4],[4,4],[4,4,4],[4,4,4,4]]
 */
public class Subsets2LeetCode90 {

    public static void main(String[] args) {
        int[] nums = new int[] {4,4,4,1,4};
        List<List<Integer>> res = subsetsWithDup(nums);
        for(List<Integer> list : res) {
            System.out.print("[");
            for(int k : list) {
                System.out.print(k + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> slate = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, slate, result);
        return result;
    }

    public static void helper(int[] nums, int index, List<Integer> slate, List<List<Integer>> result) {
        result.add(new ArrayList<>(slate));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i-1]) continue;
            slate.add(nums[i]);
            helper(nums, i+1, slate, result);
            slate.remove(slate.size()-1);
        }
    }

   /**  - one of the leetcode solution
    List<List<Integer>> ans = new ArrayList<>();
    HashSet<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        Arrays.sort(nums);
        find_subsets(nums , 0 , new ArrayList<>());
        return ans;
    }

    private void find_subsets(int[] nums,int index, List<Integer> subset)
    {
        if(!set.contains(subset))
        {
            set.add(subset);
            ans.add(new ArrayList<>(subset));
        }

        for(int i= index; i<nums.length;i++)
        {
            subset.add(nums[i]);
            find_subsets(nums, i+1, subset);
            subset.remove(subset.size()-1);
        }
    }
    */

}
