package oopconcepts;
/*
 * ketnakhalasi created on 7/12/21
 * */

public class Triangle implements Shape {
    public Triangle() {
    }
    @Override
    public void draw() {
        System.out.println("Draw a default triangle");
    }

    @Override
    public double area() {
        return 0;
    }

    public void draw(String color) {
        System.out.println("Draw a triangle of color " + color);
    }

    public void draw(String color, int size) {
        System.out.println("Draw a triangle of color " + color + " and size " + size);
    }

}
