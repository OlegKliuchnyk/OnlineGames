package ok.games.shared.cardgames.deck;

import ok.games.shared.cardgames.card.Card;
import ok.games.shared.exception.IncorrectOperationException;

import java.util.List;

public interface DealCardStrategy<T extends Card> {
    List<T> deal(List<T> cards, int countCards) throws IncorrectOperationException;
}
