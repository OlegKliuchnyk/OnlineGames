package ok.games.shared.cardgames.card;

public class Card implements Cloneable {
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
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Card))
            return false;

        Card card = (Card) o;

        return     getIndex() == card.getIndex()
                && getPower() == card.getPower()
                && getSuit() == card.getSuit()
                && getRank() == card.getRank();
    }

    @Override
    public int hashCode() {
        int result = getSuit().hashCode();
        result = 31 * result + getRank().hashCode();
        result = 31 * result + (int) getIndex();
        result = 31 * result + (int) getPower();
        return result;
    }

    @Override
    public Card clone() {
        try {
            return (Card) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError("Clone card error.");
        }
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