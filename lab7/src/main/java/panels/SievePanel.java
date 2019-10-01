package panels;

import javax.swing.*;
import java.awt.*;

public class SievePanel extends JPanel {
    /**
     * number of lines
     */
    private int n;

    public SievePanel(int n) {
        this.n = n;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawRays(g, 0,0);
        drawRays(g, getWidth(),0);
        drawRays(g, 0,getHeight());
        drawRays(g, getWidth(),getHeight());
    }

    private void drawRays(Graphics g, int x0, int y0){
        for (int i = 0; i < n; i++) {
            g.drawLine(x0, y0, getWidth() * ((getWidth()==x0 && getHeight()==y0) || (x0==0 && y0==0)?n-i:i) / n,
                    getHeight() * i / n);
        }
    }
}

