package ArraysDS;
/*
 * ketnakhalasi created on 7/30/20
 * */

public class MergeSortedArrays {

    public static void main(String[] args) {
        int[] mPlusn = new int[] {2, -1, 7, -1, -1, 10, -1};
        int mPlusnSize = mPlusn.length;
        int[] nArray = new int[] {5, 8, 12, 14};
        int n = nArray.length;
        int m = mPlusn.length - n;

        moveToEnd(mPlusn, m+n);
        merge(mPlusn, nArray, m, n);
        for(int k=0; k<mPlusnSize-1; k++){
            System.out.println(mPlusn[k]);
        }

    }

    public static void moveToEnd(int[] mPlusn, int size) {
        int j = size-1;
        for(int i = size-1; i >= 0; i--) {
            if(mPlusn[i] != -1) {
                mPlusn[j] = mPlusn[i];
                j--;
            }
        }
    }

    public static void merge (int[] mPlusn, int[] nArray, int m, int n) {
        int i = n;
        int j = 0;
        int k = 0;

        while (k< (m+n)) {
            if((i<(m+n) && mPlusn[i] <= nArray[j])) {
                mPlusn[k] = mPlusn[i];
                k++;
                i++;
            } else {
                mPlusn[k] = nArray[j];
                k++;
                j++;
            }
        }
    }
}
