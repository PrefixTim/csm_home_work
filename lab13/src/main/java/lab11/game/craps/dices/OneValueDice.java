package lab11.game.craps.dices;

/**
 * Always returns same value
 * @param <T> is an object that will be rolled
 */
public class OneValueDice<T> implements Dice<T> {
    private final T rolled;

    public OneValueDice(T rolled) {
        this.rolled = rolled;
    }

    @Override
    public T rollDice() {
        return getRolled();
    }

    @Override
    public T getRolled() {
        return rolled;
    }
}
