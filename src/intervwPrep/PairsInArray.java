package intervwPrep;
/*
 * ketnakhalasi created on 8/11/21
 * find all pairs in an array whose sum is equal to given number
 * */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class PairsInArray {
    private PairsInArray() {
        throw new AssertionError("Cannot be instantiated.");
    }

    public static List<String> pairs(int[] a, int k) {
        if(a == null || a.length < 2) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        Arrays.sort(a);
        int l = 0;
        int r = a.length - 1;

        while(l < r) {
            int sum = a[l] + a[r];
            if(sum == k) {
                result.add("(" + a[l] + ", " + a[r] + ")");
                l++;
                r--;
            } else if(sum < k) {
                l++;
            } else if (sum > k) {
                r--;
            }
        }
        return result;
    }
}
