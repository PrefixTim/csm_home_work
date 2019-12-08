package lab17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Implements the Frame for the carrot game.
 * Manages the buttons and keyboard events.
 */
class CarrotFrame extends JFrame implements ActionListener {
    public static final int DELAY = 16; // milliseconds
    private CarrotComponent carrot;
    private JButton start;
    private JButton fast;
    private JButton slow;
    private int delay;
    private double dt;
    private javax.swing.Timer timer;
    private MyKeyListener keyListener = new MyKeyListener();

    public CarrotFrame() {
        setTitle("Carrot");
        Container content = getContentPane();
        content.setLayout(new BorderLayout());
        content.setBackground(new Color(50, 150, 50));
        carrot = new CarrotComponent();
        content.add(carrot, BorderLayout.CENTER);
        carrot.setFocusable(true);
        carrot.addKeyListener(keyListener);
        JPanel panel = new JPanel();
        start = new JButton("Start");
        start.addActionListener(this);
        panel.add(start);
        start.setFocusable(false);
        fast = new JButton("Faster");
        fast.addActionListener(this);
        panel.add(fast);
        fast.setFocusable(false);
        slow = new JButton("Slower");
        slow.addActionListener(this);
        panel.add(slow);
        slow.setFocusable(false);
        delay = DELAY;
        dt = (double) delay / 1000;
        timer = new javax.swing.Timer(delay, this);
        content.add(panel, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        carrot.requestFocusInWindow();
    }

    public static void main(String... args) {
        CarrotFrame frame = new CarrotFrame();
        frame.setVisible(true);

    }

    // Handle timer and button events
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(timer)) {
            carrot.gameLoop(keyListener.getKeyPressed(), dt);
        } else if (e.getSource().equals(fast)) {
            delay = (int) (delay * 0.90);
            dt = (double) delay / 1000;
            timer.setDelay(delay);
        } else if (e.getSource().equals(slow)) {
            delay = (int) (delay / 0.90);
            dt = (double) delay / 1000;
            timer.setDelay(delay);
        } else if (e.getSource().equals(start)) {
            carrot.reset();
            timer.start();
        }
    }

}
