package lab11.game.craps.dice;

public abstract class NSideDice implements Dice{
    private int sides;
    private int number;
    private int rolledNum;

    NSideDice(int sides, int number){
        setSides(sides);
        setNumber(number);
    }

    @Override
    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int getRolledNum() {
        return rolledNum;
    }

    public void setRolledNum(int rolledNum) {
        this.rolledNum = rolledNum;
    }
}
