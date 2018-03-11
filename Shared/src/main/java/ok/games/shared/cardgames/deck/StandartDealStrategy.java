package ok.games.shared.cardgames.deck;

import ok.games.shared.cardgames.card.Card;
import ok.games.shared.exception.IncorrectOperationException;

import java.util.List;

public class StandartDealStrategy<T extends Card> implements DealCardStrategy<T> {

    @Override
    public List<T> deal(List<T> cards, int countCards) throws IncorrectOperationException {
        if(countCards < 1)
            throw new IncorrectOperationException(String.format("Parameter 'count' = %d less than 1. ", countCards));
        if(countCards > cards.size())
            throw new IncorrectOperationException(
                    String.format("Parameter 'count' = %d greater than %d (cards available in deck).",
                            countCards, cards.size())
            );

        return cards.subList(0, countCards);
    }
}
