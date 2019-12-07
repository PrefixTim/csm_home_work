package lab16;

import java.awt.*;

public class Affirm {
    private Point point;
    private String text;
    private Color color;

    // Creates an afirm with the given string and x,y
    public Affirm(String text, Color color, int x, int y) {
        this.text = text;
        this.point = new Point(x, y);
        this.color = color;
    }

    // Moves x,y by the given deltas
    public void move(int dx, int dy) {
        point.translate(dx, dy);
    }

    // True if x,y is within the rect (0,0), (width,height)
    public boolean isWithin(int width, int height) {
        return (0 <= point.x) && (point.x < width) && (0 <= point.y) && (point.y < height);
    }

    // Sets x and y
    public void setLocation(int x, int y) {
        point.setLocation(x, y);
    }

    public String getText() {
        return text;
    }

    public int getX() {
        return point.x;
    }

    public int getY() {
        return point.y;
    }

    public Color getColor() {
        return color;
    }
}