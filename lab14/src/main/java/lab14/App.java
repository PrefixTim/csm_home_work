package lab14;

import lab14.game.ui.Game;

import javax.swing.*;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new Game().setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
