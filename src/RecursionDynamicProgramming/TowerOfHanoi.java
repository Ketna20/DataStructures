package RecursionDynamicProgramming;
/*
 * ketnakhalasi created on 7/24/21
 * */

public class TowerOfHanoi {
    public static void main(String[] args) {
        int n=3;
        moveDisks(n, 'A', 'C','B');
    }

    public static void moveDisks(int n, char origin, char target, char intermediate) {
        if (n <= 0) return;
        if ( n == 1) {
            System.out.println("Move disk 1 from rod " + origin + " to rod " + target);
            return;
        }
        //move top n-1 disk from origin to intermediate using target as a intermediate
        moveDisks(n-1, origin, intermediate, target);

        System.out.println("Move Disk " + n + " from rod " + origin + " to rod " + target);

        // move top n-1 disk from intermediate to target using origin as a intermediate
        moveDisks(n-1, intermediate, target, origin);
    }


}
