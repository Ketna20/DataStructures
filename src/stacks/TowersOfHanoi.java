package stacks;
/*
 * ketnakhalasi created on 7/8/20
 * */

public class TowersOfHanoi {
    private static int count;

    public static void main(String[] args) {
        TowersOfHanoi towersOfHanoi = new TowersOfHanoi();
        towersOfHanoi.moveDisk(5, "Source", "Helper", "Destination");
        System.out.println(count + " steps");
    }

    /**
     * Move the entire stack of disks from Start peg to End peg
     * Rules:
     * 1. only one disk can be moved at a time.
     * 2. Large disk cannot be placed on a small dis k.
     */

    public void moveDisk(int n, String start, String aux, String end) {
        this.count++;
        if (n == 1) {
            // means only one disk left, so directly move
            // from source to destination
            System.out.println(start + " -> " + end);
        } else {
            // move n-1 disk from Source to Aux peg
            moveDisk(n-1, start, end, aux);

            // then move last nth disk to destination peg.
            System.out.println(start + " -> " + end);

            // Move n-1 disk from Aux peg to destination peg
            moveDisk(n-1, aux, start, end);
        }
    }

}
