package ok.games.shared.cardgames.card;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void cloneMethod() {
        Card card = new Card(Suit.DIAMONDS, Rank.FIVE);
        Card clone = card.clone();
        assertNotSame(card, clone);
    }
}