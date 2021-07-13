package oopconcepts;
/*
 * ketnakhalasi created on 7/13/21
 * */

import java.util.List;
//Example of Open Closed Principle
public class AreaCaculator {
    private final List<Shape> shapes;

    public AreaCaculator(List<Shape> shapes) {
        this.shapes = shapes;
    }

    private double sum() {
         int sum = 0;
         for (Shape shape : shapes) {
             sum += shape.area();
         }

         return sum;
    }
}
