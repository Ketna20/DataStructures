package intervwPrep;
/*
 * ketnakhalasi created on 7/28/20
 * */

public class GivenSumOfSubArray {

    public static void main(String[] args) {
//        int[] arr = new int[] {1, 2, 3, 7, 5};
//        int sum = 12;
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 15;
        int countSum = 0;
        int leftPointer = 0;
        int rightPointer = 0;
        for (int i =0; i < arr.length-1; i++) {
            countSum += arr[i];
            System.out.println("countSum is less than sum: " + countSum);
            if(countSum == sum) {
                rightPointer = i;
                break;
            }
            if (countSum > sum){
                rightPointer = i;
                do {
                    countSum -= arr[leftPointer++];
                    System.out.println("countSum is greater than sum: " + countSum);
                }
                while(countSum > sum);
                System.out.println("leftPointer : " + leftPointer);
                System.out.println("rightPointer : " + rightPointer);
                break;
            }

        }
        System.out.println("start position : " + leftPointer);
        System.out.println("end position : " + rightPointer);
    }
}
