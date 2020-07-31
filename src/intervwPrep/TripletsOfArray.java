package intervwPrep;
/*
 * ketnakhalasi created on 7/28/20
 * */

import java.util.Arrays;

public class TripletsOfArray {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 5, 7};
        int triplets = 0;
        Arrays.sort(arr);
        for (int i=arr.length-1; i>=0; i--) {
            int j=0;
            int k = i-1;
            while(j<k){
                if(arr[j]+arr[k] == arr[i]) {
                    triplets++;
                    j++;
                    k--;
                } else if(arr[j]+arr[k] < arr[i]){
                    j++;
                } else if(arr[j]+arr[k] > arr[i]){
                    k--;
                }
            }

        }
        System.out.println("Triplets: " + triplets);

    }
}
