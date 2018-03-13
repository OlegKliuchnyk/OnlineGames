package ok.games.shared.cardgames.deck;

import ok.games.shared.cardgames.card.CardWithTrump;
import ok.games.shared.exception.IncorrectOperationException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StandartDeckWithTrumpTest {

    @Test
    public void deal() throws IncorrectOperationException {
        StandartDealStrategy<CardWithTrump> cardStandartDealStrategy = new StandartDealStrategy<>();
        StandartDeckWithTrump deck = new StandartDeckWithTrump(cardStandartDealStrategy);
        CardWithTrump trump = deck.getTrump();
        assertFalse(trump == null);
        int deckSize = deck.size();
        List<CardWithTrump> cards = deck.deal(5);
        List<CardWithTrump> dealedCards = deck.getDealedCards();
        assertFalse(cards.isEmpty());
        assertFalse(dealedCards.isEmpty());
        assertTrue(deckSize == 52);
        assertTrue(deck.size() == deckSize - cards.size());
    }

    @Test(expected = IncorrectOperationException.class)
    public void incorrectDeal() throws IncorrectOperationException {
        StandartDealStrategy<CardWithTrump> cardStandartDealStrategy = new StandartDealStrategy<>();
        Deck<CardWithTrump> deck = new StandartDeckWithTrump(cardStandartDealStrategy);
        deck.deal(2);
        deck.deal(52);
    }
}