package oopconcepts.parkinglot;
/*
 * ketnakhalasi created on 7/18/21
 * */

public class ParkingSystem implements Parking {

    private final String id;
    private final ParkingLot parkingLot;

    public ParkingSystem(String id, ParkingLot parkingLot) {
        this.id = id;
        this.parkingLot = parkingLot;
    }



    @Override
    public ParkingTicket parkVehicleBtn(String licensePlate, VehicleType type) {
        if (isFull()) {
            throw new RuntimeException("The Parking Lot is full.");
        }

        Vehicle vehicle = new Vehicle(licensePlate, type.getSpotsNeeded(), type);

        return parkingLot.parkVehicle(vehicle);
    }

    @Override
    public boolean unparkVehicleBtn(String licensePlate, VehicleType type) {

        Vehicle vehicle = new Vehicle(licensePlate, type.getSpotsNeeded(), type);

        return parkingLot.unparkVehicle(vehicle);

    }

    @Override
    public boolean unparkVehicleBtn(ParkingTicket parkingTicket) {
        return parkingLot.unparkVehicle(parkingTicket);
    }

    private boolean isFull() {
        return parkingLot.isFull();
    }
}
