package ok.games.shared.cardgames;

public enum Rank {
      TWO
    , THREE
    , FOUR
    , FIVE
    , SIX
    , SEVEN
    , EIGHT
    , NINE
    , TEN
    , JACK
    , QUEEN
    , KING
    , ACE;


    @Override
    public String toString() {
        String result;

        switch (this) {
            case TWO: { result = "2"; } break;
            case THREE: { result = "3"; } break;
            case FOUR: { result = "4"; } break;
            case FIVE: { result = "5"; } break;
            case SIX: { result = "6"; } break;
            case SEVEN: { result = "7"; } break;
            case EIGHT: { result = "8"; } break;
            case NINE: { result = "9"; } break;
            case TEN: { result = "10"; } break;
            case JACK: { result = "J"; } break;
            case QUEEN: { result = "Q"; } break;
            case KING: { result = "K"; } break;
            case ACE: { result = "A"; } break;

            default: { result = "NONE"; }
        }

        return result;
    }
}
