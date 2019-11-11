package lab14;

import lab14.game.ui.GameTable;
import lab14.game.ui.MainFrame;
import lab14.old.ui.Game;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::run);
    }

    private static void run() {
        Collection<GameTable> tables = new ArrayList<>();


        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        mainFrame.getAccessibleContext();
    }
}
