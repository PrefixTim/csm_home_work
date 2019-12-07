package lab17.character;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Bunny extends Point {
    private State state = State.STATE_JUMPING;
    private BunnyKeyListener keyListener;
    private Dimension dimension;
    private Image image;
    private Image mirror;
    private boolean mirrored = false;
    private double dy = 0;
    private double dx = 0;

    public Bunny(Image image, Image reflect, Dimension dimension, int[] buttons) {
//        setImage(image, dimension);k
        this.keyListener = new BunnyKeyListener(this, buttons[0], buttons[1], buttons[2], buttons[3]);
        this.image = image;
        this.mirror = reflect;
        this.dimension = dimension;
    }

    public void draw(Graphics g) {
        g.drawImage(getImage(), x, y, dimension.width, dimension.height, null);
    }

    public Image getImage() {
        if (mirrored)
            return mirror;
        return image;
    }
//    public void setImage(Image image, Dimension dimension) {
//        this.image = image.getScaledInstance(dimension.width, dimension.height, Image.SCALE_SMOOTH);
//        this.dimension = dimension;
//
////        BufferedImage bufferedImage = new BufferedImage(dimension.width, dimension.height, BufferedImage.TYPE_INT_RGB);
////        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
////        tx.translate(-image.getWidth(null), 0);
////        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
////        this.mirror = op.filter(bufferedImage, null);
//    }

    public void translate() {
        if (dx > 0 != mirrored)
            mirrored = !mirrored;

        translate((int) dx, (int) dy);
    }

    public void setTranslation(int dx, int dy) {
        setDx(dx);
        setDy(dy);
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public BunnyKeyListener getKeyListener() {
        return keyListener;
    }

    private static class BunnyKeyListener {
        private static final double DX = 1;
        private static final double DY = 0.7;
        private Bunny bunny;
        private int up;
        private int down;
        private int left;
        private int right;

        public BunnyKeyListener(Bunny bunny, int up, int down, int left, int right) {
            this.bunny = bunny;
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
        }

        public void listen(KeyEvent e, boolean isPressed) {
            int code = e.getKeyCode();
            switch (bunny.getState()) {
                case STATE_JUMPING:
                    if (code == up) {
                        bunny.setDy(bunny.getDy() - DY);
                    } else if (code == down) {
                        bunny.setDy(bunny.getDy() + 1.05);
                    } else if (code == left) {
                        if (bunny.getDx() > -15)
                            if (bunny.getDx() > 0)
                                bunny.setDx(bunny.getDx() / 2 - DX);
                            else
                                bunny.setDx(bunny.getDx() - DX);

                    } else if (code == right) {
                        if (bunny.getDx() < 15)
                            if (bunny.getDx() < 0)
                                bunny.setDx(bunny.getDx() / 2 + DX);
                            else
                                bunny.setDx(bunny.getDx() + DX);
                    }
                case STATE_STANDING:
                    if (code == up) {
                        bunny.setDy(-25);
                        bunny.setState(State.STATE_JUMPING);
                    }
            }
        }
    }
}

