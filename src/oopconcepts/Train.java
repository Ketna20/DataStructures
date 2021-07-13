package oopconcepts;
/*
 * ketnakhalasi created on 7/13/21
 * */

public class Train {

    private final String name;

    private final Engine engine;

    public Train(String name) {
        this.name = name;
        Engine engine = new Engine("Gas", 100);
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getHorsepower() {
        return engine.getHorsepower();
    }

}
