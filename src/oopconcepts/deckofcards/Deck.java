package oopconcepts.deckofcards;
/*
 * ketnakhalasi created on 7/17/21
 * */

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Deck<T extends Card> implements Iterable<T> {
    private List<T> cards;

    public Deck(Pack pack) {
        this.cards = pack.getCards();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<T> dealHands(int numOfCards) {
        return null;
    }

    public T dealCard() {
        return null;
    }

    public int remainingCards() {
        return cards.size();
    }

    public void removeCards (List<T> cards) {

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}
