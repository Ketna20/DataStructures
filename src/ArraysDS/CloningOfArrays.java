package ArraysDS;
/*
 * ketnakhalasi created on 7/25/21
 * */

public class CloningOfArrays {
    public static void main(String[] args) {

        int[] intArray = {1, 2, 3};
        //cloning of one-dimensional array : deep copy is created
        // with new array containing copies of orig. array's elements.
        // as opposed to references.
        int[] cloneArray = intArray.clone();
        //prints false
        System.out.println("intArray == cloneArray : " + (intArray == cloneArray));

        //multi-dimensional cloning - a shallow copy is created
        // means it creates only a single new array with each element array
        // is a reference to orig. array's elements, but sub-arrays are shared.
        int[][] multiDimArray = {{1, 2, 3}, {5, 6}};
        int[][] cloneMultiDimArray = multiDimArray.clone();
        //prints false
        System.out.println("multiDimArray == cloneMultiDimArray : " + (multiDimArray == cloneMultiDimArray));
        //will print true for following as shallow copy is created
        // sub-arrays are shared.
        System.out.println(multiDimArray[0] == cloneMultiDimArray[0]);
        System.out.println(multiDimArray[1] == cloneMultiDimArray[1]);
    }
}
