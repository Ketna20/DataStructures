package oopconcepts;
/*
 * ketnakhalasi created on 7/12/21
 * */

public class ElectricCar implements Car {

    private final String carType;

    public ElectricCar(String carType) {
        this.carType = carType;
    }


    @Override
    public void speedUp() {
        System.out.println("Speed up the electric car");
    }

    @Override
    public void slowDown() {
        System.out.println("Speed down the electric car");
    }

    @Override
    public void turnLeft() {
        System.out.println("turn left the electric car");
    }

    @Override
    public void turnRight() {
        System.out.println("turn right the electric car");
    }

    @Override
    public String getCarType() {
        return this.carType;
    }
}
