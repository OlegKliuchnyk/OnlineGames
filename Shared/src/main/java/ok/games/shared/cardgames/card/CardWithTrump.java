package ok.games.shared.cardgames.card;

public class CardWithTrump extends Card {
    private boolean isTrump;

    public CardWithTrump(Suit suit, Rank rank) {
        super(suit, rank);
        this.isTrump = false;
    }

    public boolean isTrump() {
        return isTrump;
    }

    public void setTrump(boolean trump) {
        isTrump = trump;
        if (isTrump) {
            byte power = (byte) (getPower() + Rank.values().length);
            setPower(power);
        } else
            setDefaultPower();
    }

    @Override
    public CardWithTrump clone() {
        return (CardWithTrump) super.clone();
    }

    @Override
    public String toString() {
        return "CardWithTrump{" + getClass().getName() + "@" + Integer.toHexString(hashCode()) +
                ", suit=" + getSuit() +
                ", rank=" + getRank() +
                ", index=" + getIndex() +
                ", power=" + getPower() +
                ", isTrump=" + isTrump +
                '}';
    }
}
