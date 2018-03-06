package ok.games.shared.cardgames.deck;

import ok.games.shared.cardgames.card.Card;
import ok.games.shared.cardgames.card.CardWithTrump;
import ok.games.shared.cardgames.card.Rank;
import ok.games.shared.cardgames.card.Suit;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StandartDeckWithTrump extends Deck<CardWithTrump> implements DeckWithTrump<CardWithTrump> {
    private static final byte DECK_SIZE = 52;

    private CardWithTrump trump;

    public StandartDeckWithTrump(DealCardStrategy<CardWithTrump> dealStrategy) {
        super(dealStrategy);
    }

    private void setCardTrump(CardWithTrump cardTrump) {
        getCards().forEach(crd -> crd.setTrump(crd.getSuit().equals(cardTrump.getSuit())));
    }

    @Override
    public CardWithTrump getTrump() {
        return trump;
    }

    @Override
    public CardWithTrump generateTrump() {
        //todo we need check if trump not null we must generate exception.
        List<CardWithTrump> cards = getCards();
        Random rnd = new Random(System.currentTimeMillis());
        int index = rnd.nextInt(cards.size());
        trump = cards.get(index);
        setCardTrump(trump);
        return trump;
    }

    @Override
    void clear() {
        super.clear();
        trump = null;
    }

    @Override
    public void init() {
        clear();
        List<CardWithTrump> cards = getCards();
        if (cards.size() != DECK_SIZE) {
            cards = Arrays.stream(Rank.values())
                    .flatMap(rank -> Arrays.stream(Suit.values())
                            .map(suit -> new CardWithTrump(suit, rank)))
                    .collect(Collectors.toList());
            setCards(cards);
        }
    }
}
