package ok.games.shared.cardgames;

import ok.games.shared.cardgames.card.Card;

import java.util.List;

public interface CombinationDetector {
    Combination detect(List<Card> cards);
}
