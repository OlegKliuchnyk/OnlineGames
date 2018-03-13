package ok.games.shared.cardgames.deck;

import ok.games.shared.cardgames.card.CardWithTrump;
import ok.games.shared.exception.IncorrectOperationException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class DeckWithTrump<T extends CardWithTrump> extends Deck<T> {
    private T trump;

    public DeckWithTrump(DealCardStrategy<T> dealStrategy) {
        super(dealStrategy);
    }

    protected abstract T generateTrump() throws IncorrectOperationException;

    public T getTrump() {
        return trump;
    }

    protected void setTrump(T cardTrump) {
        trump = cardTrump;
        getCards().forEach(crd -> {
            boolean isTrump = crd.getSuit().equals(cardTrump.getSuit());
            setTrumpBool(crd, isTrump);
        });
    }

    @Override
    protected void clear() {
        super.clear();
        trump = null;
        getCards().forEach(crd -> setTrumpBool(crd, false));
    }

    private void setTrumpBool(T object, boolean isTrump) {
        try {
            Method method = object.getClass().getDeclaredMethod("setTrump", boolean.class);
            method.setAccessible(true);
            method.invoke(object, isTrump);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            //todo logger
            e.printStackTrace();
        }
    }
}
