package lab14;

import lab14.game.logic.dices.Dice;

import java.util.Collection;

public class Craps {
    private static final int MAX_GAME_LENGTH = 210;
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;
    private boolean ended;
    private int length;
    private int point;

    public GameResult play(Boolean giveUp) {
        length++;
        int sumOfDice = ;
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

    public void restart() {
        point = 0;
        length = 0;
    }

    private GameResult won() {
        return end(true);
    }

    private GameResult lost() {
        return end(false);
    }

private GameResult end(boolean result) {
        return new GameResult(result, length);

    }

    private void setPoint(int point) {
        this.point = point;
    }
}
