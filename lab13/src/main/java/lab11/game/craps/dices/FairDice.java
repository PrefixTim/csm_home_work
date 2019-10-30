package lab11.game.craps.dices;

/**
 * Dice that roles an Integer number from 1 to N inclusive where
 */
public class FairDice extends NSideDice<Integer> {
    private Integer rolled;
    public FairDice(int sides) {
        super(sides);
        rollDice();
    }

    @Override
    public Integer rollDice() {
        setRolled(1 + getRandom().nextInt(getSides()));
        return getRolled();
    }

    @Override
    public Integer getRolled() {
        return rolled;
    }

    private void setRolled(Integer rolled) {
        this.rolled = rolled;
    }
}
