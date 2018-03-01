package ok.games.shared.cardgames.deck;

import ok.games.shared.cardgames.card.Card;

import java.util.List;

public interface Deck<T extends Card> {
    void init();
    void shuffle();
    List<T> deal(int count);
    int size();
}