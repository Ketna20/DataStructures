package ArraysDS;

import java.util.ArrayList;

public class ArrayBasics {

    public static void main(String[] args) {
        int[] fixSizedArray = new int[5];

        // Array creation and initialization both
        int[] arr = {1, 2, 3, 4};

        // Dynamic Integer Array
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        int[] newArr = insertElement(arr, arr.length, 7, 1);
        traverseArray(newArr);

    }

    static void traverseArray(int arr[]) {
        // Traversing over arr[]
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    static int[] insertElement(int arr[], int arraySize, int insertX, int pos)
    {
        int[] newArr = new int[arraySize+1];
        for(int i=0; i<arraySize; i++) {
            newArr[i] = arr[i];
            System.out.println(newArr[i]);
        }
        int n = newArr.length;
        // shift elements to the right
        // which are on the right side of pos
        for (int i = n - 1; i >= pos; i--)
            newArr[i] = newArr[i-1];
        newArr[pos] = insertX;

        return newArr;
    }

}
