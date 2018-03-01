package ok.games.shared.cardgames.deck;

import ok.games.shared.cardgames.card.Card;
import ok.games.shared.cardgames.card.Rank;
import ok.games.shared.cardgames.card.Suit;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StandartDeck implements Deck<Card> {
    private static final byte DECK_SIZE = 52;
    private static final byte MIN_SHUFFLE_TIMES = 25;
    private static final byte MAX_SHUFFLE_TIMES = 100;

    private DealCard<Card> dealStrategy;
    private List<Card> cards;
    private List<Card> dealedCards;

    public StandartDeck(DealCard<Card> dealStrategy) {
        this.dealStrategy = dealStrategy;
        cards = new ArrayList<>(DECK_SIZE);
        dealedCards = new ArrayList<>(DECK_SIZE);
        init();
    }

    private void clear() {
        if (!dealedCards.isEmpty()) {
            cards.addAll(dealedCards);
            dealedCards.clear();
        }
    }

    @Override
    public void init() {
        clear();
        if (cards.size() != DECK_SIZE) {
            cards = Arrays.stream(Rank.values())
                    .flatMap(rank -> Arrays.stream(Suit.values())
                    .map(suit -> new Card(suit, rank)))
                    .collect(Collectors.toList());
        }
        shuffle();
    }

    @Override
    public void shuffle() {
        Random rnd = new Random(System.currentTimeMillis());
        int max = rnd.nextInt(MAX_SHUFFLE_TIMES - MIN_SHUFFLE_TIMES) + MIN_SHUFFLE_TIMES;
        IntStream.range(1, max).forEach(s ->Collections.shuffle(cards, rnd));
    }

    @Override
    public List<Card> deal(int count) {
        List<Card> result = dealStrategy.deal(new ArrayList<>(cards), count);
        cards.removeAll(result);
        dealedCards.addAll(result);
        return result;
    }

    @Override
    public int size() {
        return cards.size();
    }
}
