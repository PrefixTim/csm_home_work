package lab14.game.logic;

import lab14.game.logic.dices.Dice;
import lab14.game.logic.games.Craps;
import lab14.game.logic.games.GameResult;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CrapsPlayer implements Runnable {
    private ConcurrentLinkedQueue<GameResult> queue;
    private Craps game;

    public CrapsPlayer(ConcurrentLinkedQueue<GameResult> queue, Craps game) {
        this.queue = queue;
        this.game = game;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (game) {
                GameResult gameResult = null;
                while (game.isEnded()) {
                    gameResult = game.play(false);
                }
                if (gameResult != null)
                    queue.add(gameResult);
            }
        }
    }

    public void setDices(Collection<Dice<Integer>> dices) {
        synchronized (game) {
            if (game.isEnded())
                game.setDices(dices);
        }
    }

    public void setGame(Craps game) {
        this.game = game;
    }
}
