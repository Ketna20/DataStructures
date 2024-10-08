package leetcode75.prefixSum;

public class HighestAltitude_1732 {

    public int largestAltitude(int[] gain) {
        int alt = 0;
        int max = 0;

        for(int n : gain) {
            alt += n;
            max = Math.max(max, alt);
        }

        return max;
    }
}
