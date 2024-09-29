package LeetCode.dp;

public class UniquePaths_62 {

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;

        int[][] paths = new int[m][n];

        for (int i=0; i<m; i++) {
            paths[i][0] = 1;
        }

        for(int j=0; j<n; j++) {
            paths[0][j] = 1;
        }

        for(int row = 0; row < m; row++) {
           for(int col=0; col < n; col++) {
              paths[row][col] = paths[row-1][col] + paths[row][col-1];
           }
        }

        return paths[m-1][n-1];

    }

}
