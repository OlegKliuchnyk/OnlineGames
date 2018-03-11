package ok.games.shared.cardgames.card;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardWithTrumpTest {

    @Test
    public void cloneMethod() {
        CardWithTrump card = new CardWithTrump(Suit.HEARTS, Rank.JACK);
        card.setTrump(true);
        CardWithTrump cloned = card.clone();
        assertNotSame(card, cloned);
    }
}