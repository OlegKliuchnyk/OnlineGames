package ok.games.shared.cardgames.deck;

import ok.games.shared.cardgames.card.Card;
import ok.games.shared.exception.IncorrectOperationException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StandartDeckTest {

    @Test
    public void deal() throws IncorrectOperationException {
        StandartDealStrategy<Card> cardStandartDealStrategy = new StandartDealStrategy<>();
        Deck<Card> deck = new StandartDeck(cardStandartDealStrategy);
        int deckSize = deck.size();
        List<Card> cards = deck.deal(5);
        List<Card> dealedCards = deck.getDealedCards();
        assertFalse(cards.isEmpty());
        assertFalse(dealedCards.isEmpty());
        assertTrue(deckSize == 52);
        assertTrue(deck.size() == deckSize - cards.size());
    }

    @Test(expected = IncorrectOperationException.class)
    public void incorrectDeal() throws IncorrectOperationException {
        StandartDealStrategy<Card> cardStandartDealStrategy = new StandartDealStrategy<>();
        Deck<Card> deck = new StandartDeck(cardStandartDealStrategy);
        deck.deal(2);
        deck.deal(52);
    }
}