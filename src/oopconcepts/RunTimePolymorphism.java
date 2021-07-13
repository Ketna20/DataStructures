package oopconcepts;
/*
 * ketnakhalasi created on 7/12/21
 * */
//Polymorphism via Method Overloading - Compile Time Polymorphism
public class RunTimePolymorphism {

        public static void main(String[] args) {
            Triangle triangle = new Triangle();
            Square s = new Square();
            Circle c = new Circle();
            triangle.draw();
            s.draw();
            c.draw();
        }


}
