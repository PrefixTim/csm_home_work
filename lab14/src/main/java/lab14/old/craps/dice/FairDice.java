package lab14.old.craps.dice;

import java.util.Random;

public class FairDice extends NSideDice {
    private Random random = new Random();

    public FairDice(int sides) {
        super(sides, 1);
        rollDice();
    }

    @Override
    public int rollDice() {
        setNumber(1 + random.nextInt(getSides()));
        return getNumber();
    }
}
