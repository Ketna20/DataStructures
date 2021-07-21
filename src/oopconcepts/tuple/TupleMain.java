package oopconcepts.tuple;
/*
 * ketnakhalasi created on 7/20/21
 * */

public class TupleMain {
    public static void main(String[] args) {
        TuplePair tuplePair = TuplePair.of("left", "right");
        System.out.println(tuplePair.left);
        System.out.println(tuplePair.right);
    }
}
