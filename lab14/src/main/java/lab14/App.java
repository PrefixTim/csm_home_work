package lab14;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lab14.game.logic.GameTable;
import lab14.game.logic.games.GameResult;
import lab14.game.ui.MainFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::run);
    }

    private static void run() {
        Config config = ConfigFactory.parseResources("app.conf");
        ConcurrentLinkedQueue<GameResult> queue = new ConcurrentLinkedQueue<>();
        AtomicLong nToDo = new AtomicLong(config.getLong("todo");
        Collection<GameTable> tables = config.getConfigList("tables").stream()
                .map(config1 -> GameTable.getGameTableFromConfig(queue, nToDo, config1)).collect(Collectors.toList());
        MainFrame mainFrame = new MainFrame(tables, queue);
        mainFrame.setVisible(true);
    }
}
