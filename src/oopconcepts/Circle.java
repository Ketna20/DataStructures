package oopconcepts;
/*
 * ketnakhalasi created on 7/12/21
 * */

public class Circle implements Shape {

    private int radius;

    public Circle(){}

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("drawing a circle ...");
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
}
