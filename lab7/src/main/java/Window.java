import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Window extends JFrame {

    public Window(JPanel panel,int width, int height) {
        panel.setBackground(Color.gray);
        add(panel);
        setSize(width, height);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
