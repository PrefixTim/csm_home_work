package view;

import javax.swing.*;
import java.awt.*;

/**
 * Creates a window with panel which draws assigment
 */
public class MainFrame extends JFrame {
    public static final int WIDTH = 720;
    public static final int HEIGHT = 720;

    /**
     * @param n number of lines
     */
    public MainFrame(int n) {
        setSize(WIDTH, HEIGHT);
        JPanel mainPanel = new JPanel(){
            int numLines = n;
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                for(int i = 0; i <= n-1; i++)
                    g.drawLine(0, getHeight()/2, getWidth(), getHeight()*i/(n-1));
            }
        };
        mainPanel.setBackground(Color.gray);
        setContentPane(mainPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
