package codility;

public class TrianglePattern {

    public static void main(String[] args) {
        printHalfTriangleStars(4);
        System.out.println("Print Triangle Pattern: ");
        printTrianglePattern(4);
        System.out.println("Print Upside Down Triangle Pattern: ");
        printUpsideDownTrianglePattern(4);
    }

    /**
     * prints half triangle
     *  *
     *  * *
     *  * * *
     *  * * * *
     */
    public static void printHalfTriangleStars(int n) {
        if(n <= 0) {
            return;
        }
        for(int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void printTrianglePattern(int n) {
        if(n <= 0) {
            return;
        }
        for(int i=1; i<=n; i++) {
            for(int j=n; j>=i; j--) {
                System.out.print(" ");
            }

            for(int k=1; k<=i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void printUpsideDownTrianglePattern(int n) {
        if(n <= 0) {
            return;
        }
        for(int i=n; i>=1; i--) {
            for(int j=n; j>=i; j--) {
                System.out.print(" ");
            }
            for(int k=1; k<=i; k++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}
