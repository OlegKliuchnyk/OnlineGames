package ok.games.shared.cardgames.deck;

import ok.games.shared.cardgames.card.Card;
import ok.games.shared.cardgames.card.Rank;
import ok.games.shared.cardgames.card.Suit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StandartDeck extends Deck<Card> {
    private static final byte DECK_SIZE = 52;

    public StandartDeck(DealCardStrategy<Card> dealStrategy) {
        super(dealStrategy);
    }

    @Override
    public void init() {
        clear();
        List<Card> cards = getCards();
        if (cards.size() != DECK_SIZE) {
            cards = Arrays.stream(Rank.values())
                    .flatMap(rank -> Arrays.stream(Suit.values())
                    .map(suit -> new Card(suit, rank)))
                    .collect(Collectors.toList());
            setCards(cards);
        }
        shuffle();
    }
}
