package lab14.game.logic.dices;

import java.util.Random;

public class RegularDice extends NSideDice<Integer> {
    private Random random = new Random();

    public RegularDice(int sides) {
        super(sides, 1);
        roll();
    }

    @Override
    public Integer roll() {
        setRolled(1 + random.nextInt(getSides()));
        return getRolled();
    }
}
