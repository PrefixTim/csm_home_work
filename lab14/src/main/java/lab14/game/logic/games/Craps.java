package lab14.game.logic.games;

import lab14.game.logic.dices.Dice;

import java.util.List;


public class Craps implements DiceGame<GameResult, List<Dice<Integer>>> {
    private static final int MAX_GAME_LENGTH = 210;
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;
    private boolean ended;
    private int length;
    private int point;

    @Override
    public GameResult play(List<Dice<Integer>> input) {
        if(isEnded())
            throw new IllegalStateException("The game is ended");
        length++;
        int sumOfDice = input.stream().mapToInt(Dice<Integer>::roll).sum();
        if (length == 1) { //first round checks by first rounds rules
            switch (sumOfDice) {
                case SEVEN:
                case YO_LEVEN:
                    return  won();// won at seven and eleven
                case SNAKE_EYES:
                case TREY:
                case BOX_CARS:
                    return lost();
                default:
                    setPoint(sumOfDice);
                    break;
            }
        } else if(length <= MAX_GAME_LENGTH){ // second round
            if (sumOfDice == point) //if rolled = point game won
                return  won();
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

    private GameResult won(){
        return end(true);
    }

    private GameResult lost(){
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
}
