package lab17;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class MyKeyListener implements KeyListener {
    private Set<Integer> keyPressed = new HashSet<>();

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        keyPressed.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyPressed.remove(e.getKeyCode());
    }

    public Set<Integer> getKeyPressed() {
        return keyPressed;
    }
}
