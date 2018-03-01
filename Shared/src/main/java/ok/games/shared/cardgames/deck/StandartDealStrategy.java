package ok.games.shared.cardgames.deck;

import ok.games.shared.cardgames.card.Card;

import java.util.List;

class StandartDealStrategy<T extends Card> implements DealCard<T> {

    @Override
    public List<T> deal(List<T> cards, int countCards) {
        if(countCards < 1)
            throw new IllegalArgumentException(String.format("Parameter 'count' = %d less than 1. ", countCards));
        if(countCards > cards.size())
            throw new IllegalArgumentException(
                    String.format("Parameter 'count' = %d greater than %d (cards available in deck).",
                            countCards, cards.size())
            );

        return cards.subList(0, countCards);
    }
}
