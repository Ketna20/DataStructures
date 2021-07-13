package oopconcepts;
/*
 * ketnakhalasi created on 7/12/21
 * */

public class Square implements Shape {

    private double sideLength;

    public Square(){}

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public void draw() {
        System.out.println("drawing a square ...");
    }

    @Override
    public double area() {
        return sideLength * sideLength;
    }

}
