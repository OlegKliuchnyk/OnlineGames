package ok.games.shared.cardgames.card;

public class CardWithTrump extends Card {
    private final boolean isTrump;

    public CardWithTrump(Suit suit, Rank rank, boolean isTrump) {
        super(suit, rank);
        this.isTrump = isTrump;
        if (isTrump) {
            byte power = (byte) (getPower() + Rank.values().length);
            setPower(power);
        }
    }

    public boolean isTrump() {
        return isTrump;
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
