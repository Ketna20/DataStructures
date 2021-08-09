package trees.traversals;
/*
 * ketnakhalasi created on 8/8/21
 * */

import java.time.LocalTime;

public class BSTLandingReservationMain {
    public static void main(String[] args) {
        BSTLandingReservation<LocalTime> landingReservation = new BSTLandingReservation<>();
        landingReservation.insert(LocalTime.of(10, 10), 3);
        landingReservation.insert(LocalTime.of(10, 14), 3);
        landingReservation.insert(LocalTime.of(9, 55), 2);
        landingReservation.insert(LocalTime.of(10, 18), 1);
        landingReservation.insert(LocalTime.of(9, 58), 5);
        landingReservation.insert(LocalTime.of(9, 47), 2);
        landingReservation.insert(LocalTime.of(9, 41), 2);
        landingReservation.insert(LocalTime.of(10, 22), 1);
        landingReservation.insert(LocalTime.of(9, 50), 6); // cannot reserve this
        landingReservation.insert(LocalTime.of(10, 4), 4);

        System.out.println("\n The Landing Schedule is : ");
        landingReservation.printInOrder();

    }
}
