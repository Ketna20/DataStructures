package ArraysDS;
/*
 * ketnakhalasi created on 7/29/20
 * */

public class RotateArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int n = arr.length;
        int rotation = 2;

        leftRotate(arr, rotation, n);
        System.out.println("rotation by 2");
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static void leftRotate(int[] arr, int d, int n){
        for(int i=0; i<d; i++){
            leftRotateByOne(arr, n);
        }
    }

    public static void leftRotateByOne(int[] arr, int n) {
        int i, temp;
        temp = arr[0];
        for(i=0; i<n-1; i++){
            arr[i] = arr[i+1];
        }
        arr[i] = temp;
    }
}
