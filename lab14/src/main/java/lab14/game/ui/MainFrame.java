package lab14.game.ui;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lab14.game.logic.GameTable;
import lab14.game.logic.games.GameResult;

import javax.swing.*;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

public class MainFrame extends JFrame {
    public MainFrame() {
        Config config = ConfigFactory.parseResources("app.conf").getConfig("window");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0,0,config.getInt("width"), config.getInt("height"));
    }

    public MainFrame(Collection<GameTable> tables, ConcurrentLinkedQueue<GameResult> queue, AtomicLong nToDo) {
        this();
    }
}
