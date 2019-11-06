package lab14.old.craps.dice;

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
    public int getRolledNum() {
        return rolledNum;
    }
}
