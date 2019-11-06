package lab14.game.ui;

import lab14.game.logic.games.Craps;
import lab14.game.logic.games.GameResult;

import java.util.concurrent.ConcurrentLinkedQueue;

public class GameTable implements Runnable{
    private ConcurrentLinkedQueue<GameResult> queue;
    private Craps craps = new Craps();

    public GameTable(ConcurrentLinkedQueue<GameResult> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            GameResult gameResult = null;
            while (craps.isEnded()){
                gameResult = craps.play();
            }
        }
    }
}
