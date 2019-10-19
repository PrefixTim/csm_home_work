package view.panels;

import javax.swing.*;
import java.awt.*;

/**
 * Panel which drawing "Simple 2-D Drawing" Fig. 4.21
 */
public class Fig4_21 extends JPanel {
    private int n;

    /**
     * @param n number of rays
     */
    public Fig4_21(int n) {
        this.n = n;
    }

    /**
     * Draw fig 4.21
     *
     * @param g Graphics
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < n; i++) {
            g.drawLine(getWidth(), getHeight() * i / n, getWidth() * i / n, 0);
            g.drawLine(0, getHeight() * (n - i) / n , getWidth() * i / n, 0);
            g.drawLine(getWidth()* i / n , getHeight(), getWidth(), getHeight() * (n - i) / n );
            g.drawLine(getWidth() * i / n , getHeight(), 0, getHeight() * i / n );
        }
    }
}
