package lab11.game.craps.dices;

import java.util.Random;

/**
 * A dice with N sides implements {@code Dice} interface.
 *
 * @param <T> is class that will be returned by getRolled
 */
public abstract class NSideDice<T> implements Dice<T> {
    private Random random;
    private int sides;

    /**
     * @param sides how many sides
     */
    public NSideDice(int sides) {
        if (sides <= 0)
            throw new IllegalArgumentException(this.getClass().getName() + " can't have 0 or negative number of sides");
        this.sides = sides;
        setRandom(new Random());
    }

    public int getSides() {
        return sides;
    }



    Random getRandom() {
        return random;
    }

    protected void setRandom(Random random) {
        this.random = random;
    }
}
