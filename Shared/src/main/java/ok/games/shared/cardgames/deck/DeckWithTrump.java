package ok.games.shared.cardgames.deck;

import ok.games.shared.cardgames.card.Card;

public interface DeckWithTrump<T extends Card> extends Deck<T> {
    T getTrump();
}
