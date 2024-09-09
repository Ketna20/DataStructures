package codility;

public class BinaryRepresentation {

    public static void main(String[] args) {
        int number = 123;
        String binary = toBinary(number);
        System.out.println("Binary representation of " + number + " is: " + binary);
    }

    public static String toBinary(int number) {
        if (number == 0) {
            return "0";
        }

        StringBuilder binary = new StringBuilder();
        while (number != 0) {
            int remainder = number % 2;
            binary.insert(0, remainder);
            number /= 2;
        }

        return binary.toString();
    }


}
