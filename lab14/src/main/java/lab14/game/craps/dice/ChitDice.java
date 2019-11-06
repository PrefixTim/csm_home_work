package lab14.game.craps.dice;

public class ChitDice implements Dice {
    private final int rolledNum;

    public ChitDice(int rolledNum) {
        this.rolledNum = rolledNum;
    }

    @Override
    public int rollDice() {
        return getRolledNum();
    }

    @Override
    public int getSides() {
        return 1;
    }

    @Override
    public int getRolledNum() {
        return rolledNum;
    }
}
