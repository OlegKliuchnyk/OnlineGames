package ok.games.shared.cardgames;

import ok.games.shared.cardgames.card.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class Combination {
    private final List<Card> cards;
    private final short power;

    public Combination(List<Card> cards, short power) {
        if(cards == null)
            throw new NullPointerException("Cards was null.");
        if(cards.isEmpty())
            throw new IllegalArgumentException("Cards was empty.");
        this.cards = new ArrayList<>(cards);
        this.power = power;
    }

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    public short getPower() {
        return power;
    }
}
