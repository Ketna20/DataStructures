package ArraysDS;

import java.util.Arrays;

public class ReArrangeArray {
    /**
     * GeeksForGeeks
     * Given an array arr[] containing integers,  your task is to print the array in the order – smallest number, largest number, 2nd smallest number, 2nd largest number, 3rd smallest number, 3rd largest number and so on.
     *
     * Examples:
     *
     * Input: arr[] = [1, 4, 2, 5, 3, 7, 9, 6, 8]
     * Output: [1, 9, 2, 8, 3, 7, 4, 6, 5]
     * Explanation: Smallest number is 1. Largest number is 9. 2nd smallest number is 2. Then 2nd largest number is 8. And so on.
     */

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 2, 5, 3, 7, 9, 6, 8};
        int[] arr1 = new int[]{1, 2, 3, 4};
        rearrangeArray(arr);
    }

    public static void rearrangeArray(int arr[]) {
        Arrays.sort(arr);
        int n=arr.length;
        int[] result= new int[n];
        int left=0;
        int right=n-1;
        for(int i=0;i<n;i++){
            if(i%2==0){
                result[i]=arr[left++];
            }else{
                result[i]=arr[right--];
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] = result[i];
        }

        System.out.print("(");
        for (int i = 0; i < n; i++) {
            System.out.print(result[i]);
            if(i != n-1) {
                System.out.print(" ,");
            }
        }
        System.out.print(")");
    }
}
