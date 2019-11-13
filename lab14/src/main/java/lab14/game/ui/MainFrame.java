package lab14.game.ui;

import lab14.game.logic.GameTable;
import lab14.game.logic.games.GameResult;

import javax.swing.*;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MainFrame extends JFrame {
    public MainFrame() {
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    public MainFrame(Collection<GameTable> tables, ConcurrentLinkedQueue<GameResult> queue) {
    }
}
