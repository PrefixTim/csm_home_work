package lab14.game.logic;

import com.sun.tools.javac.util.List;
import lab14.game.logic.dices.Dice;
import lab14.game.logic.games.Craps;
import lab14.game.logic.games.DiceGame;
import lab14.game.logic.games.GameResult;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

public class GameTable implements Runnable {
    private ConcurrentLinkedQueue<GameResult> queue;
    private DiceGame game;

    public GameTable(ConcurrentLinkedQueue<GameResult> queue, DiceGame game) {
        this.queue = queue;
        this.game = game;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (game) {
                GameResult gameResult = null;
                while (craps.isEnded()) {
                    gameResult = craps.play(false);
                }
                if (gameResult != null)
                    queue.add(gameResult);
            }
        }
    }

    public void setDices(Collection<Dice> dices) {
        synchronized (game) {
            if (game.isEnded())
                game.setDices(dices);
        }
    }

    public void setGame(DiceGame game) {
        this.game = game;
    }
}
