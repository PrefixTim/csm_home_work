package milestone2;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Panel which drawing "Simple 2-D Drawing" Fig. 4.20
 */
public class DrawPanel extends JPanel {
    /**
     * number of segment (number of rays -1)
     */
    private int n;

    /**
     * @param n number of rays
     */
    public DrawPanel(int n) {
        this.n = n-1;
    }

    /**
     * Draw n rays from each corner
     * @param g Graphics
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        List<Integer> x0s = List.of(0, getWidth()), y0s = List.of(0, getHeight());
        for (int x0: x0s) for (int y0:y0s)
            for (int i = 0; i <= n; i++)
                g.drawLine(x0, y0,
                        getWidth() * ((getWidth() == x0 && getHeight() == y0) || (x0 == 0 && y0 == 0) ? n - i : i) / n,
                        getHeight() * i / n);
    }
}

