package lab17;

import lab17.character.Bunny;
import lab17.character.KeyHandler;
import lab17.character.State;
import lab17.character.Vector2D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static lab17.ImageUtils.readImage;
import static lab17.ImageUtils.scaleImage;

/*
 * Implements the main component for the carrot game.
 */
public class CarrotComponent extends JComponent {
    public static final int SIZE = 800; // initial size
    public static final int PIXELS = 50; // square size per image
    public static final Vector2D GRAVITY = new Vector2D(0, 300); // gravity move
    public static final int CARROTS = 20; // number of carrots
    private static final Vector2D BOTTOM_BOUNCE = new Vector2D(0.98, -0.8);
    private static final Vector2D SIDE_BOUNCE = new Vector2D(-0.9, 1);
    private ArrayList<Point> myPoints = new ArrayList<>(); // x,y upper left of each carrot
    private Image carrotImage;
    private List<Bunny> bunnies = new ArrayList<>();
    private List<KeyHandler> keyHandlers = new ArrayList<>();

    public CarrotComponent() {
        setPreferredSize(new Dimension(SIZE, SIZE));
        setBackground(Color.GREEN);
        carrotImage = scaleImage(readImage("carrot.png"), new Dimension(PIXELS, PIXELS));
    }

    private void addBunny(int x, int up, int down, int left, int right) {
        Vector2D pos = new Vector2D(x, getHeight() - PIXELS);
        pos.setMin(0, 0);
        pos.setMax(getWidth() - PIXELS, getHeight() - PIXELS);
        Vector2D vel = new Vector2D(0, 0);
        vel.setMin(-getHeight(), -getHeight());
        vel.setMax(getHeight(), getHeight());
        Bunny bunny = new Bunny(
                readImage("bunny.png"),
                readImage("bunnyM.png"),
                new Dimension(PIXELS, PIXELS),
                pos,
                vel,
                GRAVITY.clone());
        keyHandlers.add(new KeyHandler(bunny, up, down, left, right));
        bunnies.add(bunny);
    }

    // Utility -- create a random point within the window
    // leaving PIXELS space at the right and bottom
    private Point randomPoint() {
        return new Point((int) (Math.random() * (getWidth() - PIXELS)),
                (int) (Math.random() * (getHeight() - PIXELS)));
    }

    // Reset things for the start of a game
    public void reset() {
//        JOptionPane.showMessageDialog(this, String.format("Player 1: %d; Player 2: %d;", 0, 0));
        myPoints.clear(); // removes all the points
        for (int i = 0; i < CARROTS; i++) {
            myPoints.add(randomPoint());
        }
        bunnies = new ArrayList<>();
        keyHandlers = new ArrayList<>();
        addBunny(getWidth() / 3, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D);
        addBunny(2 * getWidth() / 3, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
        repaint();
    }

    // Advance things by one tick -- do gravity, check collisions
    public void gameLoop(Set<Integer> keyPressed, double dt) {
        keyHandlers.forEach(k -> k.handle(keyPressed));
        bunnies.forEach(bunny -> tickBunny(bunny, dt));
        repaint();
        if (myPoints.size() == 0) reset(); // new game
    }

    private void tickBunny(Bunny bunny, double dt) {
        Vector2D pos = bunny.getPosition();
        // increase dy
        // check if hit bottom
        double d = bunny.getVelocity().getY() * dt;
        if (pos.getY() + bunny.getDimension().height + d > getHeight()) {
            // back y up
            pos.setY(getHeight() - bunny.getDimension().height);
            bunny.getVelocity().mul(BOTTOM_BOUNCE);
        } else if (pos.getY() + d < 0) {
            pos.setY(0);
            bunny.getVelocity().mul(BOTTOM_BOUNCE);
        }
        if(bunny.getState() == State.JUMPING && pos.getY() > getHeight() - bunny.getDimension().getHeight() - 8 && Math.abs(bunny.getVelocity().getY()) < 80){
            bunny.setState(State.STANDING);
            bunny.getAcceleration().mul(0);
            bunny.getVelocity().approachY(0, 80);
            pos.setY(getHeight() - bunny.getDimension().height);
        }

        d = bunny.getVelocity().getX() * dt;

        if (pos.getX() + bunny.getDimension().width + d > getWidth()) {
            pos.setX(getWidth() - bunny.getDimension().width);
            bunny.getVelocity().mul(SIDE_BOUNCE);
        } else if (pos.getX() + d < 0) {
            pos.setX(0);
            bunny.getVelocity().mul(SIDE_BOUNCE);
        }


        bunny.translate(dt);
        checkCollisions(bunny);
    }

    // Check the current x,y vs. the carrots
    public int checkCollisions(Bunny bunny) {
        // removes the ith elem from an ArrayList
        int sizeBefore = myPoints.size();
        myPoints.removeIf(p -> Math.abs(p.getX() - bunny.getPosition().getX()) <= bunny.getDimension().getWidth()
                && Math.abs(p.getY() - bunny.getPosition().getY()) <= bunny.getDimension().getHeight());
        return sizeBefore - myPoints.size();
    }


    // Draws the head and carrots
    public void paintComponent(Graphics g) {
        bunnies.forEach(b -> g.drawImage(b.getImage(),
                (int) b.getPosition().getX(), (int) b.getPosition().getY(),
                b.getDimension().width, b.getDimension().height, null)
        );
        // Draw all the carrots
        for (Point p : myPoints) {
            // point.getX( ) returns a double, so we must cast to int
            g.drawImage(carrotImage, (int) (p.getX()), (int) (p.getY()), PIXELS, PIXELS, null);
        }
    }
}
