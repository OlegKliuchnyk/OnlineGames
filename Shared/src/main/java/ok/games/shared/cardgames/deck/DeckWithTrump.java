package ok.games.shared.cardgames.deck;

import ok.games.shared.cardgames.card.Card;
import ok.games.shared.exception.IncorrectOperationException;

public interface DeckWithTrump<T extends Card> {
    T getTrump();
}
