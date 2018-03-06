package ok.games.shared.cardgames.card;

public class Card {
    private final Suit suit;
    private final Rank rank;
    private final byte index;
    private byte power;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;

        byte suitValue = (byte) suit.ordinal();
        byte rankValue = (byte) rank.ordinal();
        index = (byte) (rankValue * 4 + suitValue);
        setDefaultPower();
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

    void setPower(byte power) {
        this.power = power;
    }

    void setDefaultPower() {
        byte rankValue = (byte) rank.ordinal();
        setPower(rankValue);
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