package lab17.character;

import java.awt.event.KeyEvent;
import java.util.Set;

/**
 * @since 1, 12*7/19 1:39am
 */
public class KeyHandler {
    private static final Vector2D JUMPV = new Vector2D(0, 170);
    private static final Vector2D TO_TOP = new Vector2D(0, 170);
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
            if (up) {
                player.setState(State.JUMPING);
                player.getVelocity().add(JUMPV);
            }
        } else if (player.getState() == State.JUMPING) {
            if(up){
                player.getVelocity().approach(Ve.add(TO_TOP), );
            }
        } else {
            player.setState(State.STANDING);
        }

        if (!(left && right)) {
            if (left) {

            } else if (right) {

            }
        }
    }
}

