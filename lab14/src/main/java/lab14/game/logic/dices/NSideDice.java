package lab14.game.logic.dices;

public abstract class NSideDice<T> implements Dice<T>{
    private int sides;
    private T rolled;

    NSideDice(int sides, int number){
        setSides(sides);
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    @Override
    public T getRolled() {
        return rolled;
    }

    public void setRolled(T rolled) {
        this.rolled = rolled;
    }
}
