package lab17.character;

import java.util.Arrays;

/**
 * for fun
 *
 * @since 1, 12/7/2019 00:44 am
 */
public class Vector2D extends Vector{

    public Vector2D(){
        super(0, 2);
    }

    public Vector2D(double x, double y) {
        super(new double[]{x, y});
    }

    @Override
    public Vector2D clone() {
        Vector2D clone = new Vector2D(getX(), getY());
        if (getMax() != null)
            clone.setMax(Arrays.copyOf(getMax(), getMax().length));
        if (getMin() != null)
            clone.setMin(Arrays.copyOf(getMin(), getMin().length));
        return clone;
    }

    public void setMin(double x, double y) {

        setMin(new double[]{x, y});
    }

    public void setMax(double x, double y) {
        setMax(new double[]{x, y});
    }

    public double getY() {
        return get(1);
    }

    public Vector2D setY(double y) {
        set(1, y);
        return this;
    }

    public double getX() {
        return get(0);
    }

    public Vector2D setX(double x) {
        set(0, x);
        return this;
    }


    public void approachX(double goal, double speed) {
        approach(goal, speed, 0);
    }

    public void approachY(double goal, double speed) {
        approach(goal, speed, 1);
    }
}
