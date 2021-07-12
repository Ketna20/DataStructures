package oopconcepts;
/*
 * ketnakhalasi created on 7/12/21
 * */

public class EncapsulationExample {

    public static void main(String[] args) {
        Cat myCat = new Cat();
        myCat.feed();
        myCat.play();
        myCat.feed();
        myCat.sleep();
        System.out.println("Energy: " + myCat.getEnergy());
        System.out.println("Hungry: " + myCat.getHungry());
        System.out.println("mood: " + myCat.getMood());
    }
}
