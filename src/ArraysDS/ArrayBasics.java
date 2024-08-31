package ArraysDS;

import java.sql.Array;
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
        System.out.println("New Array after insert Element");
        traverseArray(newArr);

        boolean is7Present = isElementExist(newArr, 7);
        System.out.println();
        System.out.println("7 is exist in newArray: " + is7Present);

        boolean is9Present = isElementExist(newArr, 9);
        System.out.println("9 is exist in newArray: " + is9Present);

        int position =  findElementPosition(newArr, 3);
        System.out.println("position of 3 in newArr:  " + position);


        System.out.println("Delete 2:");
        int newArrSize = deleteElement(newArr, 2);
        System.out.println();
        System.out.println("newArrSize after deletion " + newArrSize);
    }

    static void traverseArray(int arr[]) {
        // Traversing over arr[]
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if(i < arr.length-1) {
                System.out.print(", ");
            }
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

    static boolean isElementExist(int arr[], int k) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == k) {
                return true;
            }
        }
        return false;
    }

    // find element in array
    static int findElementPosition(int arr[], int key) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    // delete element from an array
    static int deleteElement(int arr[], int key) {
        int position = findElementPosition(arr, key);
        int n = arr.length;
        if(position == -1) {
            System.out.println("Element is not found.");
            return n;
        }
        for(int i=position; i<n-1; i++) {
            arr[i] = arr[i+1];
        }
        int[] newArr = copyArr(arr);
        traverseArray(newArr);
        return newArr.length;
    }

    static int[] copyArr(int oldArr[]) {
        int length = oldArr.length;
        int newArr[] = new int[length-1];
        for(int i=0; i<length-1; i++) {
            newArr[i] = oldArr[i];
        }
        return newArr;
    }


}
