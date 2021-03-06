package milestone2;

import javax.swing.*;
import java.awt.*;

/**
 * Frame that shows DrawPanel
 */
public class Milestone2 extends JFrame {

    /**
     * Creates a windows with gray background and one panel
     *
     * @param width  width of the window
     * @param height height of the window
     */
    public Milestone2(int n, int width, int height) {
        DrawPanel panel = new DrawPanel(n);
        panel.setBackground(Color.gray);
        add(panel);
        setSize(width, height);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
