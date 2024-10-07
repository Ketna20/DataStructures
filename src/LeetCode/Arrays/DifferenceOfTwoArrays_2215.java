package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DifferenceOfTwoArrays_2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();

        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        List<Integer> l1 = new ArrayList<>(set1);
        List<Integer> l2 = new ArrayList<>(set2);

        l1.removeAll(set2);
        l2.removeAll(set1);

        result.add(l1);
        result.add(l2);



        return result;
    }
}
