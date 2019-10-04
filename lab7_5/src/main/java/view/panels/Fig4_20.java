package view.panels;

import javax.swing.*;
import java.awt.*;

/**
 * Panel which drawing "Simple 2-D Drawing" Fig. 4.20
 */
public class Fig4_20 extends JPanel {
    private int n;

    /**
     * @param n number of rays
     */
    public Fig4_20(int n) {
        this.n = n;
    }

    /**
     * Draw n rays from each corner
     *
     * @param g Graphics
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawRays(g, 0, 0);
        drawRays(g, getWidth(), 0);
        drawRays(g, 0, getHeight());
        drawRays(g, getWidth(), getHeight());
    }

    /**
     * draw n numbers of rays from the A=(x0, y0)
     * working only than A is one of the corners
     *
     * @param g  Graphics
     * @param x0 coordinate x to start rays
     * @param y0 coordinate y to start rays
     */
    private void drawRays(Graphics g, int x0, int y0) {
        for (int i = 0; i < n; i++) {
            g.drawLine(x0, y0, getWidth() * ((getWidth() == x0 && getHeight() == y0) || (x0 == 0 && y0 == 0) ? n - i : i) / n,
                    getHeight() * i / n);
        }
    }
}

