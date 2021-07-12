package oopconcepts;
/*
 * ketnakhalasi created on 7/12/21
 * */

public class Cat {
    private int mood = 50;
    private int hungry = 50;
    private int energy = 50;

    private void meow() {
        System.out.println("meow ...");
    }

    public void sleep() {
        System.out.println("Sleep ...");
        energy++;
        hungry++;
    }

    public void play() {
        System.out.println("Playing ...");
        mood++;
        energy--;
        meow();
    }

    public void feed() {
        System.out.println("Eating ...");
        mood++;
        energy++;
        hungry--;
        meow();
    }

    public int getMood() {
        return mood;
    }

    public int getHungry() {
        return hungry;
    }

    public int getEnergy() {
        return energy;
    }
}
