package ok.games.shared.cardgames;

public class Card {
    private final Suit suit;
    private final Rank rank;
    private final byte index;
    private final short power;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;

        byte suitValue = (byte) suit.ordinal();
        byte rankValue = (byte) rank.ordinal();
        index = (byte) (rankValue * 4 + suitValue);
        power = rankValue;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public byte getIndex() {
        return index;
    }

    public short getPower() {
        return power;
    }

    @Override
    public String toString() {
        return "Card{" + super.toString() +
                ", suit=" + suit +
                ", rank=" + rank +
                ", index=" + index +
                ", power=" + power +
                '}';
    }
}