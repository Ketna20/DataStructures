package oopconcepts.deckofcards;
/*
 * ketnakhalasi created on 7/17/21
 * */

import oopconcepts.Car;

public class DeckOfCardsMain {
    public static void main(String[] args) {
        //create a single card
        Card sevenHeart = new StandardCard(StandardSuit.HEARTS, 7);

        //create a complete deck of standard cards
        Pack pack = new StandardPack();
        Deck deck = new Deck(pack);

        System.out.println("Remaining Cards : " + deck.remainingCards());
    }
}
