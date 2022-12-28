package ik.learn.recursion;

/* Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 *   Input: nums = [1,1,2]
 *   Output:
 *   [[1,1,2],
 *   [1,2,1],
 *   [2,1,1]]
* */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations2LeetCode47 {

    public static void main(String[] args) {
        int[] nums = new int[] {1,1,2};
        List<List<Integer>> res = permute(nums);
        for(List<Integer> r : res) {
            System.out.print(r.toString());
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(nums, 0, result);
        return result;

    }

    private static void permuteHelper(int[] nums, int index, List<List<Integer>> result) {
        //base case
        if(index == nums.length) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i=0; i< nums.length; i++) {
                list.add(nums[i]);
            }
            result.add(list);
            return;
        }
        Set<Integer> intSet = new HashSet<>();
        for(int i=index; i<nums.length; i++) {
            if(intSet.contains(nums[i])) {
                continue;
            } else {
                intSet.add(nums[i]);
                swap(nums, i, index);
                permuteHelper(nums, index+1, result);
                swap(nums, i, index);
            }

        }
    }

    private static void swap(int[] nums, int i, int index) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
}
