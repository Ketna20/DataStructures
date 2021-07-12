package oopconcepts;
/*
 * ketnakhalasi created on 7/12/21
 * */

public class AbstractionExample {

    public static void main(String[] args) {
        ElectricCar myCar = new ElectricCar("Tesla");
        System.out.println("Driving electric car : " + myCar.getCarType());
        myCar.speedUp();
        myCar.slowDown();
        myCar.turnLeft();
        myCar.turnRight();
    }
}
