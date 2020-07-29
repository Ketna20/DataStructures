package intervwPrep;
/*
 * ketnakhalasi created on 7/15/20
 * */

import java.util.HashSet;
import java.util.Set;

public class SocksMerchant {

    public static void main(String[] args) {
        int[] ar = new int[] {10, 20, 20, 10, 10, 30, 50, 10, 20};
        int n = ar.length;
        int pairs = sockMerchant(n, ar);
        System.out.println(pairs);

    }

    static int sockMerchant(int n, int[] ar){
        Set<Integer> colors = new HashSet<>();
        int pairs = 0;

        for (int i = 0; i < n; i++) {
            if (!colors.contains(ar[i])) {
                colors.add(ar[i]);
            } else {
                pairs++;
                colors.remove(ar[i]);
            }
        }

        return pairs;
    }


}
