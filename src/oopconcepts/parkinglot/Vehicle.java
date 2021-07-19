package oopconcepts.parkinglot;
/*
 * ketnakhalasi created on 7/17/21
 * */

import java.util.Objects;

public class Vehicle {
    private final String licensePlate;
    private final int spotsNeeded;
    private final VehicleType vehicleType;


    public Vehicle(String licensePlate, int spotsNeeded, VehicleType vehicleType) {
        this.licensePlate = licensePlate;
        this.spotsNeeded = spotsNeeded;
        this.vehicleType = vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", spotsNeeded=" + spotsNeeded +
                ", vehicleType=" + vehicleType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return spotsNeeded == vehicle.spotsNeeded &&
                Objects.equals(licensePlate, vehicle.licensePlate) &&
                vehicleType == vehicle.vehicleType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(licensePlate, spotsNeeded, vehicleType);
    }
}
