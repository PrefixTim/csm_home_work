package lab14.game.ui.stat;

import lab14.game.logic.games.GameResult;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Graph extends JPanel {
    private ConcurrentLinkedQueue<GameResult> queue;

    public Graph(ConcurrentLinkedQueue<GameResult> queue) {
        this.queue = queue;
    }

    @Override
    public void print(Graphics g) {
        super.print(g);
        queue.poll();
    }
}