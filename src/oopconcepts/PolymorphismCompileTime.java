package oopconcepts;
/*
 * ketnakhalasi created on 7/12/21
 * */
//Polymorphism via Method Overloading - Compile Time Polymorphism
public class PolymorphismCompileTime {

        public static void main(String[] args) {
            Triangle triangle = new Triangle();
            triangle.draw();
            triangle.draw("red");
            triangle.draw("blue", 10);
        }


}
