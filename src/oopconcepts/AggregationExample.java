package oopconcepts;
/*
 * ketnakhalasi created on 7/13/21
 * */

public class AggregationExample {

    public static void main(String[] args) {
        Racket babolate = new Racket("Babolat Pure Aero", 100, 300);
        TennisPlayer steve = new TennisPlayer("Steve", babolate);

        System.out.println(steve.getName() + " plays with " + steve.getRacket().getType());
    }
}


