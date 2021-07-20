package oopconcepts.parkinglot;
/*
 * ketnakhalasi created on 7/17/21
 * */

import java.util.Map;

public class ParkingLot {
    private String name;
    private Map<String, ParkingFloor> floors;

    public ParkingLot(String name) {
        this.name = name;
    }

    public ParkingLot(String name, Map<String, ParkingFloor> floors) {
        this.name = name;
        this.floors = floors;

    }

    //Delegate to proper parking floor
    public ParkingTicket parkVehicle(Vehicle vehicle) {
        for(ParkingFloor floor : floors.values()) {
            if(!floor.isFull(vehicle.getVehicleType())) {
                ParkingTicket parkingTicket = floor.parkVehicle(vehicle);
                if(parkingTicket != null) {
                    return parkingTicket;
                }
            }
        }
        return null; // returning null is not a good practice.
    }

    public boolean unparkVehicle(Vehicle vehicle) {
        for(ParkingFloor floor : floors.values()) {
            boolean success = floor.unparkVehicle(vehicle);
            if(success) {
                return true;
            }
        }

        return false;
    }

    public boolean unparkVehicle(ParkingTicket parkingTicket) {
        return floors.get(parkingTicket.getFloorName()).unparkVehicle(parkingTicket);
    }

    public boolean isFull() {
        return false;
    }

    public boolean isFull(VehicleType vehicleType) {
        return false;
    }

    protected boolean addFloor(ParkingFloor floor) { return false;}
    protected boolean removeFloor(ParkingFloor floor) { return false;}
}
