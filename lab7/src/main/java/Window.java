import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Window which contains one Frame
 */
public class Window extends JFrame {

    /**
     * Creates a windows with gray background and one panel
     *
     * @param panel panel to be added into window
     * @param width width of the window
     * @param height height of the window
     */
    public Window(JPanel panel,int width, int height) {
        panel.setBackground(Color.gray);
        add(panel);
        setSize(width, height);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
