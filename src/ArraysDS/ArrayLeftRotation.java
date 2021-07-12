package ArraysDS;

public class ArrayLeftRotation {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int rotate = 1;
        int length = a.length;

        int[] b = new int[length];

        int mod = 3 % length;
        System.out.println(mod + " : mod");
        for(int i = 0; i < length; ++i) {
            System.out.print(a[(i + mod) % length]
                    + " ");
        }


    }
}
