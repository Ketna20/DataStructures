package oopconcepts.deckofcards;
/*
 * ketnakhalasi created on 7/17/21
 * */

public abstract class Card {
    private final StandardSuit suit;
    private final int value;

    private boolean available = Boolean.TRUE;

    protected Card(StandardSuit suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public StandardSuit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public boolean isAvailable() {
        return available;
    }

    public void markAvailable() {
        available = true;
    }

    public void markUnAvailable() {
        available = false;
    }

}
