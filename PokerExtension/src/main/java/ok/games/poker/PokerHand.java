package ok.games.poker;

import ok.games.shared.cardgames.Combination;
import ok.games.shared.cardgames.card.Card;

import java.util.List;

public class PokerHand extends Combination {
    private final HandName handName;

    public PokerHand(HandName handName, List<Card> cards, short power) {
        super(cards, power);
        this.handName = handName;
    }

    public HandName getHandName() {
        return handName;
    }
}
