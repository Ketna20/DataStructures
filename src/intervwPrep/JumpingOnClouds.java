package intervwPrep;
/*
 * ketnakhalasi created on 7/15/20
 * */

public class JumpingOnClouds {

    public static void main(String[] args) {
       // int clouds = 7;
        int[] cloudArray = new int[] {0, 0, 0, 1, 0, 0};
        int jumps = jumpingOnClouds(cloudArray);
        System.out.println(jumps);
    }

    static int jumpingOnClouds(int[] c) {

        int n = c.length;
        int jumps = -1;
        for (int i = 0; i < n; i++, jumps++) {
            if (i<n-2 && c[i+2]==0)
                i++;
        }

        return jumps;
    }
}
