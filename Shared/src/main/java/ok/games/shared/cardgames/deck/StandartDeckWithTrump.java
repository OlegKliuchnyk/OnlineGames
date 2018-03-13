package ok.games.shared.cardgames.deck;

import ok.games.shared.cardgames.card.CardWithTrump;
import ok.games.shared.cardgames.card.Rank;
import ok.games.shared.cardgames.card.Suit;
import ok.games.shared.exception.IncorrectOperationException;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StandartDeckWithTrump extends Deck<CardWithTrump> implements DeckWithTrump<CardWithTrump> {
    private final static Logger logger = Logger.getLogger(StandartDeckWithTrump.class);
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
        return trump.clone();
    }

    CardWithTrump generateTrump() throws IncorrectOperationException {
        if(trump != null)
            throw new IncorrectOperationException("Trump already generated.");
        List<CardWithTrump> cards = getCards();
        Random rnd = new Random(System.currentTimeMillis());
        int index = rnd.nextInt(cards.size());
        trump = cards.get(index);
        setCardTrump(trump);
        return getTrump();
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
        shuffle();
        try {
            generateTrump();
        } catch (IncorrectOperationException e) {
            logger.error("Can't generate trump.", e);
        }
    }
}
