package lab17.character;

import lab17.CarrotComponent;

import java.util.Set;

/**
 * @since 1, 12*7/19 1:39am
 */
public class KeyHandler {
    private static final Vector2D FRICTION = new Vector2D(0.99, 1);
    private static final double JUMP = -300;
    private static final double TO_TOP = 17;
    private static final double TO_SIDE = 20;

    private final int UP;
    private final int DOWN;
    private final int LEFT;
    private final int RIGHT;
    private Bunny player;

    public KeyHandler(Bunny player, int up, int down, int left, int right) {
        this.player = player;
        this.UP = up;
        this.DOWN = down;
        this.LEFT = left;
        this.RIGHT = right;
    }


    public void handle(Set<Integer> keyPressed) {
        boolean up = keyPressed.contains(UP);
        boolean down = keyPressed.contains(DOWN);
        boolean left = keyPressed.contains(LEFT);
        boolean right = keyPressed.contains(RIGHT);

        if (player.getState() == State.STANDING) {
            if (up || player.getVelocity().getY() != 0.0) {
                player.getVelocity().approachY(JUMP, TO_TOP * (1.0 + 2*player.getVelocity().getY()/JUMP));
            }
            if (player.getVelocity().getY() <= JUMP) {
                player.setState(State.JUMPING);
            }
        } else if (player.getState() == State.JUMPING) {
            if (up) {
                player.getAcceleration().approachY(CarrotComponent.GRAVITY.getY() - 150, TO_TOP);
            } else if (down) {
                player.getAcceleration().approachY(CarrotComponent.GRAVITY.getY() + 300, TO_TOP);
            } else {
                player.getAcceleration().setY(CarrotComponent.GRAVITY.getY());
            }
        } else {
            player.setState(State.STANDING);
        }

        if (!(left && right)) {
            if (left) {
                if (player.getVelocity().getY() > 0)
                    player.getVelocity().approachX(-300, TO_SIDE * 2);
                else
                    player.getVelocity().approachX(-300, TO_SIDE);
            } else if (right) {

                if (player.getVelocity().getY() < 0)
                    player.getVelocity().approachX(300, TO_SIDE * 2);
                else
                    player.getVelocity().approachX(300, TO_SIDE);
            } else {
                if(Math.abs(player.getVelocity().getX()) < 5)
                    player.getVelocity().setX(0);
                else
                    player.getVelocity().mul(FRICTION);
            }
        }
    }
}

