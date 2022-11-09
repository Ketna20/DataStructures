package ik.learn.recursion;

/* Given an array of distinct integers, return all the possible permutations.
*  You can return the answer in any order.
*   Input: nums : [1,2,3]
*   Output : [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
*   Input: nums = [0,1]
*   Output: [[0,1],[1,0]]
* */

import java.util.ArrayList;
import java.util.List;

public class PermutationsLeetCode46 {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
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

        for(int i=index; i<nums.length; i++) {
            swap(nums, i, index);
            permuteHelper(nums, index+1, result);
            swap(nums, i, index);
        }
    }

    private static void swap(int[] nums, int i, int index) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
}
