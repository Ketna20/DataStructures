package codility;

public class BinaryGap {

    public static void main(String[] args) {
        int number = 9;
        int binaryGap = findBinaryGap(number);
        System.out.println("Binary gap of " + number + " is: " + binaryGap);
    }

    public static int findBinaryGap(int number) {
        int maxGap = 0;
        boolean gapStarted = false;
        int currentGap = 0;

        while (number != 0) {
            if ((number & 1) == 1) {
                if (gapStarted) {
                    maxGap = Math.max(maxGap, currentGap);
                    currentGap = 0;
                } else {
                    gapStarted = true;
                }
            } else {
                if (gapStarted) {
                    currentGap++;
                }
            }

            number >>= 1;
        }

        return maxGap;
    }


}
