package lab17;

import lab17.character.Bunny;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * Implements the main component for the carrot game.
 */
public class CarrotComponent extends JComponent {
    public static final int SIZE = 500; // initial size
    public static final int PIXELS = 50; // square size per image
    public static final int MOVE = 20; // keyboard move
    public static final double GRAVITY = 1.05; // gravity move
    public static final int CARROTS = 20; // number of carrots
    private ArrayList<Point> myPoints; // x,y upper left of each carrot
    private Image carrotImage;
    private List<Bunny> bunnies = new ArrayList<>();

    public CarrotComponent() {
        setPreferredSize(new Dimension(SIZE, SIZE));

        addKeyListener();

        // getScaledInstance( ) gives us re-sized version of the image --
        // speeds up the drawImage( ) if the image is already the right size
        // See paintComponent( )
        bunnies.add(new Bunny(readImage("bunny.png"), readImage("bunnyM.png"),
                new Dimension(PIXELS, PIXELS), new int[] {KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D}));
        bunnies.add(new Bunny(readImage("bunny.png"), readImage("bunnyM.png"),
                new Dimension(PIXELS, PIXELS), new int[]{KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT}));

        carrotImage = readImage("carrot.png");
        carrotImage = carrotImage.getScaledInstance(PIXELS, PIXELS,
                Image.SCALE_SMOOTH);
        myPoints = new ArrayList<>();
    }

    // Utility -- create a random point within the window
    // leaving PIXELS space at the right and bottom
    private Point randomPoint() {
        Point p = new Point((int) (Math.random() * (getWidth() - PIXELS)),
                (int) (Math.random() * (getHeight() - PIXELS)));
        return (p);
    }

    // Reset things for the start of a game
    public void reset() {
        myPoints.clear(); // removes all the points
        for (int i = 0; i < CARROTS; i++) {
            myPoints.add(randomPoint());
        }
        for (Bunny bunny : bunnies) {
            bunny.setLocation(getWidth() / 2, 0);
            bunny.setTranslation(0, 0);
        }
        repaint();
    }

    // Advance things by one tick -- do gravity, check collisions
    public void tick() {
        bunnies.forEach(this::tickBunny);
        repaint();
    }

    private void tickBunny(Bunny bunny) {
        if (bunny.getY() < getHeight() - PIXELS)
            bunny.setDy(bunny.getDy() + GRAVITY);
        // increase dy
        // check if hit bottom
        if (bunny.getY() + bunny.getDimension().height + bunny.getDy() >= getHeight()) {
            // back y up
            bunny.setLocation(bunny.getX(), getHeight() - bunny.getDimension().height);
            bunny.setDy((int) (0.98 * -bunny.getDy()));
        } else if (bunny.getY() + bunny.getDy() < 0) {
            bunny.setLocation(bunny.getX(), 0);
            bunny.setDy((int) (0.58 * -bunny.getDy()));
        }

        if (bunny.getX() + bunny.getDimension().width + bunny.getDx() >= getWidth()) {
            bunny.setLocation(getWidth() - bunny.getDimension().width, bunny.getY());
            bunny.setDx((int) (0.76 * -bunny.getDx()));
        } else if (bunny.getX() + bunny.getDx() < 0) {
            bunny.setLocation(0, bunny.getY());
            bunny.setDx((int) (0.76 * -bunny.getDx()));
        }
        bunny.translate();
        System.out.println(checkCollisions(bunny));
    }


    public void keyEventProcess(KeyEvent e, boolean isPressed) {
        bunnies.forEach(bunny -> bunny.getKeyListener().listen(e, isPressed));
    }
    // Utility to read in an bImage object
    // If image cannot load, prints error output and returns null.
    private Image readImage(String filename) {
        Image image = null;
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResource("../" + filename)));
        } catch (IOException e) {
            System.out.println("Failed to load image '" + filename + "'");
            e.printStackTrace();
        }
        return (image);
    }

    // Check the current x,y vs. the carrots
    public int checkCollisions(Bunny bunny) {
        // removes the ith elem from an ArrayList
        int sizeBefore = myPoints.size();
        myPoints.removeIf(p -> Math.abs(p.getX() - bunny.x) <= PIXELS - 6
                && Math.abs(p.getY() - bunny.getY()) <= PIXELS - 6);

        //bug set to change flag
        if (myPoints.size() == 0) {
            reset(); // new game
        }
        return sizeBefore - myPoints.size();
    }


    // Draws the head and carrots
    public void paintComponent(Graphics g) {
        bunnies.forEach(b -> b.draw(g));
        // Draw all the carrots
        for (Point p : myPoints) {
            // point.getX( ) returns a double, so we must cast to int
            g.drawImage(carrotImage, (int) (p.getX()), (int) (p.getY()), PIXELS, PIXELS, null);
        }
    }
}
