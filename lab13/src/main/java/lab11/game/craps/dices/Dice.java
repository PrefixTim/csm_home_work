package lab11.game.craps.dices;

/**
 * Dice that can be rolled and read the rolled. May roll any object for example there are may be dices
 * which roll numbers, images, or letters(Like dice from monopoly).
 * @param <T> is an object that will be rolled
 */
public interface Dice<T> {
    /**
     * It's rolls dice(change its state) and returns its state because very often getRolled used after rollDice.
     * @return state of the dice
     */
    T rollDice();

    /**
     * @return state of the dice
     */
    T getRolled();
}
