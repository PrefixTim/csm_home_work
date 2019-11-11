package lab14.game.logic.dices;

public class ChitDice<T> implements Dice<T> {
    private final T rolled;

    public ChitDice(T rolled) {
        this.rolled = rolled;
    }

    @Override
    public T roll() {
        return getRolled();
    }

    @Override
    public T getRolled() {
        return rolled;
    }
}
