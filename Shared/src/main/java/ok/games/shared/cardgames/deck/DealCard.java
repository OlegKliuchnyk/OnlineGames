package ok.games.shared.cardgames.deck;

import ok.games.shared.cardgames.card.Card;

import java.util.List;

public interface DealCard<T extends Card> {
    List<T> deal(List<T> cards, int countCards);
}
