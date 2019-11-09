package lab14.game.logic.games;

import lab14.game.logic.dices.Dice;

import java.util.Collection;

public class Craps implements DiceGame<Boolean, GameResult, Integer> {
    private static final int MAX_GAME_LENGTH = 210;
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;
    private boolean ended;
    private int length;
    private int point;
    private Collection<Dice<Integer>> dices;

    public Craps(Collection<Dice<Integer>> dices) {
        if(dices.size() != 2) throw new IllegalStateException("Wrong amount of dice");
        this.dices = dices;
    }

    @Override
    public GameResult play(Boolean giveUp) {
        if (isEnded()) throw new IllegalStateException("The game is ended");
        if (giveUp) return lost();
        length++;
        int sumOfDice = dices.stream().mapToInt(Dice::roll).sum();
        if (point == 0) { //first round checks by first rounds rules
            switch (sumOfDice) {
                case SEVEN:
                case YO_LEVEN:
                    return won();// won at seven and eleven
                case SNAKE_EYES:
                case TREY:
                case BOX_CARS:
                    return lost();
                default:
                    setPoint(sumOfDice);
                    break;
            }
        } else if (length <= MAX_GAME_LENGTH) { // second round
            if (sumOfDice == point) //if rolled = point game won
                return won();
            else if (sumOfDice == SEVEN) //if
                return lost();
        } else {
            return lost();
        }
        return null;
    }

    @Override
    public Boolean restart() {
        point = 0;
        length = 0;
        ended = false;
        return true;
    }

    @Override
    public Boolean isEnded() {
        return ended;
    }

    private GameResult won() {
        return end(true);
    }

    private GameResult lost() {
        return end(false);
    }

    private GameResult end(boolean won) {
        setEnded(true);
        return new GameResult(won, length);

    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }

    private void setPoint(int point) {
        this.point = point;
    }

    @Override
    public void setDices(Collection<Dice<Integer>> dices) {
        this.dices = dices;
    }
}
