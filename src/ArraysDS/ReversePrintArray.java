package ArraysDS;

public class ReversePrintArray {

    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 4};
        int[] reversed = reverseArray(a);

    }

    public static int[] reverseArray(int[] a) {
        int[] b = new int[a.length];
        System.out.println(b.length);
        for (int i = a.length-1; i>=0; i--) {
           // System.out.println(a[i]);
            b[i] = a[i];
            System.out.println(b[i]);
        }
        return b;
    }

}
