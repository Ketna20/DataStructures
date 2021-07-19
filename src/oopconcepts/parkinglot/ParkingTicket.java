package oopconcepts.parkinglot;
/*
 * ketnakhalasi created on 7/17/21
 * */

import java.time.LocalDateTime;
import java.util.List;

public final class ParkingTicket {
    private Vehicle vehicle;
    private final LocalDateTime releaseDate;
    private final List<String> parkingSpotLabels;
    private final String floorName;

    public ParkingTicket(Vehicle vehicle, LocalDateTime releaseDate, List<String> parkingSpotLabels, String floorName) {
        this.vehicle = vehicle;
        this.releaseDate = releaseDate;
        this.parkingSpotLabels = parkingSpotLabels;
        this.floorName = floorName;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public List<String> getParkingSpotLabels() {
        return parkingSpotLabels;
    }

    public String getFloorName() {
        return floorName;
    }

    @Override
    public String toString() {
        return "ParkingTicket{" +
                "vehicle=" + vehicle +
                ", releaseDate=" + releaseDate +
                ", parkingSpotLabels=" + parkingSpotLabels +
                ", floorName='" + floorName + '\'' +
                '}';
    }
}
