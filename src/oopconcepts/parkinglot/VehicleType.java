package oopconcepts.parkinglot;

public enum VehicleType {
    CAR(1), VAN(2), TRUCK(5);

    private final int spotsNeeded;

    VehicleType(int spotsNeeded) {
        this.spotsNeeded = spotsNeeded;
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }
}
