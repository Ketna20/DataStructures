package ik.learn.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * Input: candidates = [2], target = 1
 * Output: []
 */
public class CombinationSumLeetCode39 {

    public static void main(String[] args) {
        int[] candidates = new int[] {2,3,6,7};
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates, target);
        for(List<Integer> r : result) {
            System.out.print("[");
            for(int i: r) {
                System.out.print(i + ",");
            }
            System.out.println("]");
            System.out.println();
        }
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
//        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        helper(list, new ArrayList<Integer>(), candidates, 0, 0, target);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] cand, int remain, int start) {
        if (remain < 0) return; /** no solution */
        else if (remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for (int i = start; i < cand.length; i++) {
                tempList.add(cand[i]);
                backtrack(list, tempList, cand, remain-cand[i], i);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public static void helper(List<List<Integer>> result, List<Integer> slate, int[] cand, int slateSum, int i, int target) {
        // Backtracking case
        if(slateSum == target) {
            result.add(new ArrayList<>(slate));
            return;
        } else if(slateSum > target) {
            return;
        }

        // Base case
        if(i == cand.length) {
            return;
        }
        //Recursive case
        for (int start = i; start < cand.length; start++) {
            // Exclude cand[i]
            helper(result, slate, cand, slateSum, i+1, target);
            // Include cand[i]
            slate.add(cand[i]);
            slateSum += cand[i];
            helper(result, slate, cand, slateSum, i+1, target);
            slate.remove(slate.size()-1);
        }

    }
}
