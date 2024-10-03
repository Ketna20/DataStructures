package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortEvenOddIndices_2164 {

    public int[] sortEvenOdd(int[] nums) {
        int n= nums.length;

        if(n<3) return nums;

        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();

        int[] res = new int[n];

        for(int i=0; i<n; i++) {
            if(i%2 == 0) {
                evenList.add(nums[i]);
            } else {
                oddList.add(nums[i]);
            }
        }

        Collections.sort(evenList);

        Collections.sort(oddList);
        Collections.reverse(oddList);

        int j=0;
        int k=0;
        for(int i=0; i<n; i++) {
            if(i%2 == 0) {
                res[i] = evenList.get(j++);
            } else {
                res[i] = oddList.get(k++);
            }
        }

        return res;
    }
}
