package ok.games.shared.cardgames.deck;

import ok.games.shared.cardgames.card.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public abstract class Deck<T extends Card> {
    private static final byte MIN_SHUFFLE_TIMES = 25;
    private static final byte MAX_SHUFFLE_TIMES = 100;

    private DealCardStrategy<T> dealStrategy;
    private List<T> cards;
    private List<T> dealedCards;

    public Deck(DealCardStrategy<T> dealStrategy) {
        this.dealStrategy = dealStrategy;
        cards = new ArrayList<>();
        dealedCards = new ArrayList<>();
        init();
    }

    public abstract void init();

    void clear() {
        if (!dealedCards.isEmpty()) {
            cards.addAll(dealedCards);
            dealedCards.clear();
        }
    }

    List<T> getCards() {
        return cards;
    }

    void setCards(List<T> cards) {
        this.cards = cards;
    }

    List<T> getDealedCards() {
        return dealedCards;
    }

    void setDealedCards(List<T> dealedCards) {
        this.dealedCards = dealedCards;
    }

    public void shuffle() {
        Random rnd = new Random(System.currentTimeMillis());
        int max = rnd.nextInt(MAX_SHUFFLE_TIMES - MIN_SHUFFLE_TIMES) + MIN_SHUFFLE_TIMES;
        IntStream.range(1, max).forEach(s -> Collections.shuffle(cards, rnd));
    }

    public List<T> deal(int count) {
        List<T> result = dealStrategy.deal(new ArrayList<>(cards), count);
        cards.removeAll(result);
        dealedCards.addAll(result);
        return result;
    }

    public int size() {
        return cards.size();
    }
}