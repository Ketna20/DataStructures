package ArraysDS;

public class TwoDimensionalArray {

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        arr[0][0] = 1;
        arr[0][1] = 6;
        arr[0][2] = 4;
        arr[0][3] = 5;
        arr[0][4] = 4;
        arr[0][5] = 4;

        arr[1][0] = 2;
        arr[1][1] = 5;
        arr[1][2] = 3;
        arr[1][3] = 3;
        arr[1][4] = 3;
        arr[1][5] = 3;

        arr[2][0] = 5;
        arr[2][1] = 7;
        arr[2][2] = 1;
        arr[2][3] = 1;
        arr[2][4] = 1;
        arr[2][5] = 1;

        arr[3][0] = 1;
        arr[3][1] = 6;
        arr[3][2] = 4;
        arr[3][3] = 4;
        arr[3][4] = 4;
        arr[3][5] = 4;

        arr[4][0] = 2;
        arr[4][1] = 5;
        arr[4][2] = 3;
        arr[4][3] = 3;
        arr[4][4] = 3;
        arr[4][5] = 3;

        arr[5][0] = 5;
        arr[5][1] = 7;
        arr[5][2] = 1;
        arr[5][3] = 1;
        arr[5][4] = 1;
        arr[5][5] = 1;

        int maxSum = Integer.MIN_VALUE;

        for (int i=0; i<arr.length-2; i++) {
            for(int k=0; k<arr.length-2; k++){
                int sum = arr[i][k] + arr[i][k+1] + arr[i][k+2]
                            + arr[i+1][k+1] +
                          arr[i+2][k] + arr[i+2][k+1] + arr[i+2][k+2];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        System.out.println(maxSum);
        // Max Sum of hourglass

    }

}
