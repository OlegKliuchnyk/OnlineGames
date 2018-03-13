package ok.games.shared.cardgames.deck;

import ok.games.shared.cardgames.card.Card;
import ok.games.shared.exception.IncorrectOperationException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public abstract class Deck<T extends Card> {
    private static final byte MIN_SHUFFLE_TIMES = 50;
    private static final byte MAX_SHUFFLE_TIMES = Byte.MAX_VALUE;
    private static final byte DEFAULT_DECK_SIZE = 52;

    private DealCardStrategy<T> dealStrategy;
    private List<T> cards;
    private List<T> dealedCards;

    public Deck(DealCardStrategy<T> dealStrategy) {
        if(dealStrategy == null)
            throw new NullPointerException("Deal strategy was null.");
        this.dealStrategy = dealStrategy;
        setDeckCapacity(DEFAULT_DECK_SIZE);
        init();
    }

    public abstract void init();

    protected void setDeckCapacity(int capacity) {
        cards = new ArrayList<>(capacity);
        dealedCards = new ArrayList<>(capacity);
    }

    protected void clear() {
        if (!dealedCards.isEmpty()) {
            cards.addAll(dealedCards);
            dealedCards.clear();
        }
    }

    protected List<T> getCards() {
        return cards;
    }

    protected void setCards(List<T> cards) {
        if(cards == null)
            throw new NullPointerException("Cards was null.");
        this.cards.clear();
        this.cards.addAll(cards);
    }

    protected List<T> getDealedCards() {
        return dealedCards;
    }

    protected void setDealedCards(List<T> dealedCards) {
        if(dealedCards == null)
            throw new NullPointerException("Dealed cards was null.");
        this.dealedCards.clear();
        this.dealedCards.addAll(dealedCards);
    }

    protected void shuffle() {
        Random rnd = new Random(System.currentTimeMillis());
        int max = rnd.nextInt(MAX_SHUFFLE_TIMES - MIN_SHUFFLE_TIMES) + MIN_SHUFFLE_TIMES;
        IntStream.range(1, max).forEach(s -> Collections.shuffle(cards, rnd));
    }

    public synchronized List<T> deal(int count) throws IncorrectOperationException {
        List<T> result = dealStrategy.deal(new ArrayList<>(cards), count);
        cards.removeAll(result);
        dealedCards.addAll(result);
        return result;
    }

    public int size() {
        return cards.size();
    }
}