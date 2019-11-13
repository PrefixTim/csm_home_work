package lab14.game.logic;

import com.typesafe.config.Config;
import lab14.game.logic.games.Craps;
import lab14.game.logic.games.GameResult;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

public class GameTable implements Runnable {
    private ConcurrentLinkedQueue<GameResult> queue;
    private final AtomicLong nToDo;
    private Craps craps;

    public GameTable(ConcurrentLinkedQueue<GameResult> queue, AtomicLong nToDo, Craps craps) {
        this.queue = queue;
        this.nToDo = nToDo;
        this.craps = craps;
    }

    @Override
    public void run() {
        if (queue == null) throw new IllegalStateException("Queue is not set");
        while (!Thread.currentThread().isInterrupted()) {
            if (nToDo.get() <= 0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                   Thread.currentThread().interrupt();
                   return;
                }
            } else {
                nToDo.decrementAndGet();
                craps.restart();
                queue.add(craps.play());
            }
        }
    }

    public static GameTable getGameTableFromConfig(ConcurrentLinkedQueue<GameResult> queue, AtomicLong nToDo, Config config) {

    }
}