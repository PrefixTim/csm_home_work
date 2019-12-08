package lab17.character;

import lab17.ImageUtils;

import java.awt.*;


/**
 * Bunny
 *
 * @since 3, 12/4/2019 1:25pm
 */
public class Bunny {
    private Image image;
    private Image mirror;
    private boolean mirrored = false;

    private Dimension dimension;
    private Vector2D position;
    private Vector2D velocity;
    private Vector2D acceleration;

    private State state = State.JUMPING;

    public Bunny(Image image, Image reflect, Dimension dimension, Vector2D position, Vector2D velocity, Vector2D acceleration) {
        this.dimension = dimension;
        this.image = ImageUtils.scaleImage(image, dimension);
        this.mirror = ImageUtils.scaleImage(reflect, dimension);
        setPosition(position);
        setVelocity(velocity);
        setAcceleration(acceleration);
    }

    public Image getImage() {
        if (mirrored)
            return mirror;
        return image;
    }

    public void translate(double dt) {
        position.translate(velocity, dt, true);
        velocity.translate(acceleration, dt, true);
        if (position.getX() > 0 != mirrored)
            mirrored = !mirrored;
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

    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
        if (position.getX() > 0 != mirrored)
            mirrored = !mirrored;
    }

    public Vector2D getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2D velocity) {
        this.velocity = velocity;
    }

    public Vector2D getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector2D acceleration) {
        this.acceleration = acceleration;
    }

}

