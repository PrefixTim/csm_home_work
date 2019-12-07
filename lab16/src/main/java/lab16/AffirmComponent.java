package lab16;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class AffirmComponent extends JComponent {
    private static final Font FONT = new Font("Dialog", Font.PLAIN, 24);
    private static final int SIZE = 400;
    private static final int SPEED = 8;
    private static Random rand = new Random();
    private ArrayList<Affirm> affirms = new ArrayList<>();

    public AffirmComponent() {
        setPreferredSize(new Dimension(SIZE, SIZE));
    }

    // Draw all the affirmations.
    public void paintComponent(Graphics g) {
        g.setFont(FONT);
        affirms.forEach(a -> {
            g.setColor(a.getColor());
            g.drawString(a.getText(), a.getX(), a.getY());
        });
    }

    // Adds a string -- make and add an Affirm for the string
    public void add(String string) {
        affirms.add(new Affirm(
                string,
                new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat()),
                rand.nextInt(getWidth()),
                rand.nextInt(getHeight())));
        repaint();
    }

    // Removes an affirmation at random
    public void removeRandom() {
        if (affirms.size() > 0) affirms.remove(rand.nextInt(affirms.size()));
        repaint();
    }

    // Moves all the affirmations a little
    public void moveAll() {
        int width = getWidth();
        int height = getHeight();
        for (Affirm a : affirms) {
            // random values in the range –SPEED ... +SPEED
            int dx = rand.nextInt(2 * SPEED + 1) - SPEED;
            int dy = rand.nextInt(2 * SPEED + 1) - SPEED;
            a.move(dx, dy);
            if (!a.isWithin(width, height)) {
                a.setLocation(rand.nextInt(width), rand.nextInt(height));
            }
        }
        repaint();
    }

    public void center() {
        affirms.forEach(a -> a.setLocation((getWidth() - a.getX())/ 2, (getHeight() - a.getY())/ 2));
        repaint();
    }
}
