package intervwPrep;
/*
 * ketnakhalasi created on 8/12/21
 * */

import java.util.List;

public class PairsInArrayMain {
    public static void main(String[] args) {
        int sum = 10;
        int[] a = new int[]{-5, -2, 5, 4, 3, 7, 2, 1, -1, -2, 15, 6, 12, -4, 3};
        List<String> pairs = PairsInArray.pairs(a, sum);
        System.out.println("Pairs are: " + pairs);
    }
}
