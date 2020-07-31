package ArraysDS;
/*
 * ketnakhalasi created on 7/29/20
 * */

public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5};
        int start = 0;
        int end = arr.length-1;

        // using swap - iterative way
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }

        System.out.println("Reversed Again!");

        //recursive way
        reverseArray(arr, 0, arr.length-1);

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }

    }

    //recursive way
    public static void reverseArray(int[] arr, int start, int end) {
        int temp = 0;
        if(start >= end) {
            return;
        }

        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseArray(arr,start+1, end-1);

    }
}
