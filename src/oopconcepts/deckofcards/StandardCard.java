package oopconcepts.deckofcards;
/*
 * ketnakhalasi created on 7/17/21
 * */

public class StandardCard extends Card {
    private static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 13;

    public StandardCard(StandardSuit suit, int value) {
        super(suit, value);
    }

    public static int getMinValue() {
        return MIN_VALUE;
    }

    public static int getMaxValue() {
        return MAX_VALUE;
    }
}
