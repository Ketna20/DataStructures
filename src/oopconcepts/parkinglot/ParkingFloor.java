package oopconcepts.parkinglot;
/*
 * ketna khalasi created on 7/17/21
 * */

import java.util.*;
import java.util.stream.Collectors;

public class ParkingFloor {
    private final String floorName;
    private final int totalSpots;
    private final Map<String, ParkingSpot> parkingSpots = new LinkedHashMap<>();
    private final Set<ParkingTicket> parkingTickets = new HashSet<>();
     private int totalFreeSpots; // should be managed when giving away spots


    public ParkingFloor(String name, int totalSpots) {
        this.floorName = name;
        this.totalSpots = totalSpots;
        
        initialize(); // create parking spots
    }

    private void initialize() {
        for(int i=1; i <= totalSpots; i++) {
            parkingSpots.put("#" + i, new ParkingSpot("#" + i, this));
        }
    }

    protected ParkingTicket parkVehicle(Vehicle vehicle) {
        List<ParkingSpot> parkingSpots = findSpotsToFitVehicle(vehicle);
        if(parkingSpots.isEmpty())
            return null;
        assignVehicleToParkingSpots(parkingSpots, vehicle);
        ParkingTicket parkingTicket = releaseParkingTicket(vehicle, parkingSpots);
        registerParkingTicket(parkingTicket);
        return parkingTicket;
    }

    private void registerParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTickets.add(parkingTicket);
    }

    private void unRegisterParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTickets.remove(parkingTicket);
    }

    private ParkingTicket releaseParkingTicket(Vehicle vehicle, List<ParkingSpot> parkingSpots) {
        List<String> spotsLabels = parkingSpots.stream()
                .map(ParkingSpot::getLabel)
                .collect(Collectors.toList());
        return new ParkingTicket(vehicle, spotsLabels, this.floorName);
    }

    private void assignVehicleToParkingSpots(List<ParkingSpot> parkingSpots, Vehicle vehicle) {
            for(ParkingSpot ps : parkingSpots) {
                ps.assignVehicle(vehicle);
            }
    }

    private List<ParkingSpot> findSpotsToFitVehicle(Vehicle vehicle) {
        int count = 0;
        List<ParkingSpot> freeSpots = new ArrayList<>();
        int neededSpots = vehicle.getSpotsNeeded();
        for(int i=1; i <= totalSpots; i++) {
            if(parkingSpots.get("#" + i).isFree()) {
                count++;
                freeSpots.add(parkingSpots.get("#" + i));
            } else {
                count = 0;
                freeSpots.clear();
            }

            if(count == neededSpots) {
                return freeSpots;
            }
        }
        freeSpots.clear();
        return freeSpots;
    }

    //we have to find vehicle by looping through the parking spots
    protected boolean unparkVehicle(Vehicle vehicle) {

        ParkingTicket parkingTicket = findParkingTicket(vehicle);

        if(!parkingTickets.contains(parkingTicket)) return false;
        int countSpots = 0; //need to free the number of spots occupied by vehicle
        for (ParkingSpot spot : parkingSpots.values()) {
            if (spot.getVehicle() != null && spot.getVehicle().equals(vehicle)) {
                boolean success = spot.removeVehicle();
                if (!success) return false;

                if(++countSpots == vehicle.getSpotsNeeded()) {
                    break;
                }
            }
        }
        unRegisterParkingTicket(parkingTicket);
        
        return true;
    }

    protected boolean unparkVehicle(ParkingTicket parkingTicket) {
        if(!parkingTickets.contains(parkingTicket)) {
            throw new RuntimeException("This ticket is not in our system!");
        }
         List<String> spots = parkingTicket.getParkingSpotLabels();
        for(String spot : spots) {
            boolean success = parkingSpots.get(spot).removeVehicle();
            if (!success) return false;
        }

        unRegisterParkingTicket(parkingTicket);
        return true;
    }

    protected boolean isFull(VehicleType vehicleType) {
        return false;
    }

    protected int countFreeSpots(VehicleType vehicleType) {
        return 0;
    }



    private ParkingTicket findParkingTicket(Vehicle vehicle) {
        for(ParkingTicket pt : parkingTickets) {
            if(pt.getVehicle().equals(vehicle)) {
                return pt;
            }
        }
        return null;
    }

    public String getFloorName() {
        return floorName;
    }

    public int getTotalSpots() {
        return totalSpots;
    }

    public Map<String, ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public Set<ParkingTicket> getParkingTickets() {
        return parkingTickets;
    }

    public int getTotalFreeSpots() {
        return totalFreeSpots;
    }

    public void setTotalFreeSpots(int totalFreeSpots) {
        this.totalFreeSpots = totalFreeSpots;
    }
}
