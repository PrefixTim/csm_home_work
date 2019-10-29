package milestone4;

import javax.swing.*;
import java.awt.*;

/**
 * Frame that shows DrawPanel
 */
public class Milestone4 extends JFrame {

    /**
     * Creates a windows with gray background and one panel
     *
     * @param d dimension of width and height of the window
     */
    public Milestone4(int n, Dimension d) {
        DrawPanel panel = new DrawPanel(n);
        panel.setBackground(Color.gray);
        add(panel);
        setSize(d);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
