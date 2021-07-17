package oopconcepts.deckofcards;
/*
 * ketnakhalasi created on 7/17/21
 * */

import java.util.List;

public abstract class Pack<T extends Card> {
    private List<T> cards;

    protected abstract List<T> build();

    public int packSize() {
        return cards.size();
    }

    public List<T> getCards() {
        return cards;
    }

    public void setCards(List<T> cards) {
        this.cards = cards;
    }
}
