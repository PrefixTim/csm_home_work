package lab17.character;

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

    public void setMin(double x, double y) {

        setMin(new double[]{x, y});
    }

    public void setMax(double x, double y) {
        setMax(new double[]{x, y});
    }

    public double getY() {
        return get(1);
    }

    public void setY(int y) {
        set(1, y);
    }

    public double getX() {
        return get(0);
    }

    public void setX(int x) {
        set(0, x);
    }
}
