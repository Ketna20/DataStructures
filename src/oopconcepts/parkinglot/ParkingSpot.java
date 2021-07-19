package oopconcepts.parkinglot;
/*
 * ketnakhalasi created on 7/17/21
 * */

public class ParkingSpot {

    private final String label;
    private final ParkingFloor parkingFloor;

    private boolean free = true;
    private Vehicle vehicle;


    public ParkingSpot(String label, ParkingFloor parkingFloor) {
        this.label = label;
        this.parkingFloor = parkingFloor;
    }

    public String getLabel() {
        return label;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    protected boolean assignVehicle(Vehicle vehicle) {
        System.out.println("Assign " + label + " at floor " + parkingFloor.getFloorName()
        + " to Vehicle " + vehicle);
        this.free = false;
        this.vehicle = vehicle;
        return true;
    }

    protected boolean removeVehicle() {
        System.out.println("Free " + label + " at floor " + parkingFloor.getFloorName()
                + " vehicle" + vehicle);
        this.free = true;
        this.vehicle = null;
        return true;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "label='" + label + '\'' +
                '}';
    }
}
