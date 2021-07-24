package RecursionDynamicProgramming;
/*
 * ketnakhalasi created on 7/23/21
 * */

public class RobotGridAllPaths {
    public static void main(String[] args) {
        int paths = countPaths(6, 6);
        int memoizationPaths = countPathBottomUp(6, 6);

        System.out.println("paths : " + paths);
        System.out.println("memoizationPaths : " + memoizationPaths);
    }

    //plain recursion
    public static int countPaths(int m, int n) {
        if(m <= 0 || n <= 0) {
            return -1;
        }

        //go in any cell of the first row
        if(m == 1 || n == 1) {
            return 1;
        }
        return countPaths(m-1, n) + countPaths(m, n-1);
        // if diagonal movements allowed the add : + countPath(m-1, n-1)
    }

    //Memoization
    public static int countPathBottomUp(int m, int n) {
        if (m <= 1 || n <= 1) {
            return -1;
        }

        //cache the results of sub problems
        int[][] count = new int[m][n];

        // go in any cell of the first row is 1
        for (int i=0; i<m; i++) {
            count[i][0] = 1;
        }

        // go in any cell of the first column is 1
        for (int j=0; j<n; j++) {
            count[0][j] = 1;
        }

        //determine the paths for other cells in bottom up manner
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                count[i][j] = count[i-1][j] + count[i][j-1];
                // if diagonal movements allowed the add : + count[i-1][j-1]
            }
        }

        return count[m-1][n-1];
    }

}
