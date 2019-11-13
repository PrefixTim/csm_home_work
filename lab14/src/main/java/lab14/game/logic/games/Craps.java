package lab14.game.logic.games;

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
    private Collection<Dice<Integer>> dices;
    private GameResult result;

    public Craps(Collection<Dice<Integer>> dices) {
        if(dices.size() != 2) throw new IllegalStateException("Wrong amount of dice");
        this.dices = dices;
    }

    /**
     * simulates craps play
     * @return
     */
    public GameResult play() {
        if (isEnded()) throw new IllegalStateException("The game is ended");
        while (isEnded()) {
            length++;
            int sumOfDice = dices.stream().mapToInt(Dice::roll).sum();
            if (point == 0) { //first round checks by first rounds rules
                switch (sumOfDice) {
                    case SEVEN:
                    case YO_LEVEN:
                        won();// won at seven and eleven
                        break;
                    case SNAKE_EYES:
                    case TREY:
                    case BOX_CARS:
                        lost();
                        break;
                    default:
                        setPoint(sumOfDice);
                        break;
                }
            } else if (length <= MAX_GAME_LENGTH) { // second round
                if (sumOfDice == point) //if rolled = point game won
                    won();
                else if (sumOfDice == SEVEN) //if seven lost
                    lost();
            } else {
                lost();
            }
        }
        return getResult();
    }

    public void restart() {
        setLength(0);
        setResult(null);
        setEnded(false);
        setPoint(0);
    }

    public Boolean isEnded() {
        return ended;
    }

    private void won() {
        end(true);
    }

    private void lost() {
        end(false);
    }

    /**
     * ends game and sets a game result
     * @param result is game won or not
     */
    private void end(boolean result) {
        setEnded(true);
        this.result = new GameResult(result, length);
    }

    private void setLength(int length) {
        this.length = length;
    }

    private void setResult(GameResult result) {
        this.result = result;
    }

    private void setEnded(boolean ended) {
        this.ended = ended;
    }

    private void setPoint(int point) {
        this.point = point;
    }

    public void setDices(Collection<Dice<Integer>> dices) {
        this.dices = dices;
    }

    public GameResult getResult() {
        if (!isEnded()) throw  new IllegalStateException("The games is not ended yet");
        if (result == null) throw new IllegalStateException("Game ended but result is not set");
        return result;
    }
}
