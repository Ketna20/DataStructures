package oopconcepts.parkinglot;
/*
 * ketnakhalasi created on 7/19/21
 * */

import java.util.HashMap;
import java.util.Map;

public class ParkingSystemMain {

    public static void main(String[] args) {
        Map<String, ParkingFloor> floors = new HashMap<>();
        floors.put("Aqua", new ParkingFloor("Aqua", 5) );
        floors.put("Magenta", new ParkingFloor("Magenta", 5) );
        ParkingLot parkingLot = new ParkingLot("SkyParking", floors);

        ParkingSystem parkingSystem = new ParkingSystem("1", parkingLot);

        //Parking a van
        System.out.println("\n\n");
        ParkingTicket pt1 = parkingSystem.parkVehicleBtn("Van1", VehicleType.VAN);
        ParkingTicket pt2 = parkingSystem.parkVehicleBtn("Car1", VehicleType.CAR);
        ParkingTicket pt3 = parkingSystem.parkVehicleBtn("Truck1", VehicleType.TRUCK);
        System.out.println("\n\n");
        System.out.println("Parking ticket: " + pt1);
        System.out.println("Parking ticket: " + pt2);
        System.out.println("Parking ticket: " + pt3);

        //unpark vehicles
        System.out.println("unparking done : " + parkingSystem.unparkVehicleBtn(pt1));
        System.out.println("unparking done : " + parkingSystem.unparkVehicleBtn(pt2));
        System.out.println("unparking done : " + parkingSystem.unparkVehicleBtn(pt3));
    }
}
