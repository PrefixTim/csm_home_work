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
    private CarrotComponent carrot;
    private JButton start;
    private JButton fast;
    private JButton slow;
    private int delay;
    private javax.swing.Timer timer;
    public static final int DELAY = 50; // milliseconds

    public CarrotFrame() {
        setTitle("Carrot");
        Container content = getContentPane();
        content.setLayout(new BorderLayout());
        carrot = new CarrotComponent();
        content.add(carrot, BorderLayout.CENTER);
        carrot.setFocusable(true);
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
        timer = new javax.swing.Timer(delay, this);
        content.add(panel, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        carrot.requestFocusInWindow();
        setVisible(true);
    }

    // Handle timer and button events
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(timer)) {
            carrot.tick();
        } else if (e.getSource().equals(fast)) {
            delay = (int) (delay * 0.90);
            timer.setDelay(delay);
        } else if (e.getSource().equals(slow)) {
            delay = (int) (delay / 0.90);
            timer.setDelay(delay);
        } else if (e.getSource().equals(start)) {
            carrot.reset();
            timer.start();
        }
    }



    public static void main(String[] args) {
        CarrotFrame frame = new CarrotFrame();
//        T t = frame::r;
//        System.out.println(t.t());

        int[] s = new int[]{1, 3};
        System.out.println(s.getClass());
    }

    int r() {
        return 2;
    }

    interface T {
        int t();
    }
}
