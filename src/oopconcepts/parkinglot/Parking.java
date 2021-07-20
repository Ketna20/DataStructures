package oopconcepts.parkinglot;

public interface Parking {
    public ParkingTicket parkVehicleBtn(String licensePlate, VehicleType type);
    public boolean unparkVehicleBtn(String LicensePlate, VehicleType type);
    public boolean unparkVehicleBtn(ParkingTicket parkingTicket);
}
