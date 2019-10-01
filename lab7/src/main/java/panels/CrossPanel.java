package panels;

import javax.swing.*;
import java.awt.*;


/**
 * Panel which drawing two crosses
 */
public class CrossPanel extends JPanel {

    /**
     * Drawing two crosses
     *
     * @param g Graphics
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int h = getHeight();
        int w = getWidth();
        g.drawLine(0, 0, w, h);
        g.drawLine(0, h, w, 0);
        g.drawLine(0, h / 2, w, h / 2);
        g.drawLine(w / 2, 0, w / 2, h);
    }
}
