package milestone4;

import javax.swing.*;
import java.awt.*;

/**
 * Panel which drawing "Simple 2-D Drawing" Fig. 4.20
 */
public class DrawPanel extends JPanel {
    /**
     * number of segment (number of rays + 1)
     */
    private int n;

    /**
     * @param n number of rays
     */
    public DrawPanel(int n) {
        this.n = n + 1;
    }

    /**
     * Draw n rays from each corner
     *
     * @param g Graphics
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < n; i++) {
            g.drawLine(getWidth() * i / n, 0, getWidth(), getHeight() * i / n);
            g.drawLine(getWidth() * i / n, 0, 0, getHeight() * (n - i) / n);
            g.drawLine(getWidth() * i / n, getHeight(), getWidth(), getHeight() * (n - i) / n);
            g.drawLine(getWidth() * i / n, getHeight(), 0, getHeight() * i / n);
        }
    }
}
