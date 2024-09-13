package strings;

/**
 * Leetcode: 2086
 * You are given a 0-indexed string hamsters where hamsters[i] is either:
 *
 * 'H' indicating that there is a hamster at index i, or
 * '.' indicating that index i is empty.
 * You will add some number of food buckets at the empty indices in order to feed the hamsters. A hamster can be fed if there is at least one food bucket to its left or to its right. More formally, a hamster at index i can be fed if you place a food bucket at index i - 1 and/or at index i + 1.
 *
 * Return the minimum number of food buckets you should place at empty indices to feed all the hamsters or -1 if it is impossible to feed all of them.
 * Example 1:
 *  Input: hamsters = "H..H"
 *  Output: 2
 *  Explanation: We place two food buckets at indices 1 and 2.
 *  It can be shown that if we place only one food bucket, one of the hamsters will not be fed.
 * Example 2:
 *  Input: hamsters = ".H.H."
 *  Output: 1
 *  Explanation: We place one food bucket at index 2.
 *  Example 3:
 *  Input: hamsters = ".HHH."
 *  Output: -1
 *  Explanation: If we place a food bucket at every empty index as shown, the hamster at index 2 will not be able to eat.
 */
public class MinBucketToFeedHamsters {

    public static void main(String[] args) {
        String hamsters = "H..H";
        int buckets = minimumBuckets(hamsters);
        System.out.println(" minimum buckets needed: " + buckets);
    }

    /**
     * Time complexity O(n)
     * Space complexity O(1)
     * @param hamsters
     * @return
     */
    public static int minimumBuckets(String hamsters) {
        if(hamsters.equals("H")) {
            return -1;
        }
        if(hamsters.equals(".")) {
            return 0;
        }
        int n = hamsters.length();
        int buckets = 0;

        for(int i=0; i<n; i++) {
            if(hamsters.charAt(i) == 'H') {
                if(i < n-1 && hamsters.charAt(i+1) == '.') {
                    buckets++;
                    i += 2;
                } else if(i > 0 && hamsters.charAt(i-1) == '.') {
                    buckets++;
                } else {
                    return -1;
                }
            }
        }
        return buckets;
    }
}
