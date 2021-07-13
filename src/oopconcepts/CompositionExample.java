package oopconcepts;
/*
 * ketnakhalasi created on 7/13/21
 * */

public class CompositionExample {

    public static void main(String[] args) {
        Train train = new Train("MyTrain");

        System.out.println("Horsepower: " + train.getHorsepower());
    }
}
