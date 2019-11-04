package lab11.game.craps.logic;

import lab11.game.craps.dices.Dice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lab11.game.craps.logic.GameStatus.*;

public class Craps {
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;
    private GameStatus gameStatus;
    private int point;
    private List<Dice> dices;

    public Craps(Dice... dices) {
        this(Arrays.asList(dices));
    }

    public Craps(List<Dice> dices) {
        this.dices = dices;
        gameStatus = BEGINNING;
        point = 0;
    }

    public void play() {
        if (gameStatus == LOST || gameStatus == WON) // if the game ended return
            return;

        // calculating sum of all dices
        int sumOfDice = rollDices().stream().mapToInt(Integer::intValue).sum();

        if (gameStatus == BEGINNING) { //first round checks by first rounds rules
            switch (sumOfDice) {
                case SEVEN:
                case YO_LEVEN:
                    setGameStatus(WON); // won at seven and eleven
                    break;
                case SNAKE_EYES:
                case TREY:
                case BOX_CARS:
                    setGameStatus(LOST); // lost at 2 3 12
                    break;
                default:
                    setGameStatus(CONTINUE); // other case set point and continue
                    setPoint(sumOfDice);
                    break;
            }
        } else if (gameStatus == CONTINUE) { // second round
            if (sumOfDice == point) //if rolled = point game won
                setGameStatus(WON);
            else if (sumOfDice == SEVEN) //if
                gameStatus = GameStatus.LOST;
        }
    }

    private List<Integer> rollDices() {
        return dices.stream().map(Dice<Integer>::rollDice).collect(Collectors.toList());
    }

    public List<Dice> getDices() {
        return dices;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    private void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getPoint() {
        return point;
    }

    private void setPoint(int point) {
        this.point = point;
    }
}
