package ok.games.shared.cardgames;

public enum Suit {
      HEARTS
    , DIAMONDS
    , CLUBS
    , SPADES;


    @Override
    public String toString() {
        String result;
        switch (this) {
            case HEARTS: { result = "♥"; } break;
            case DIAMONDS: { result = "♦"; } break;
            case CLUBS: { result = "♣"; } break;
            case SPADES: { result = "♠"; } break;
            default: {result = "NONE"; }
        }
        return result;
    }
}