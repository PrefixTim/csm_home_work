package milestone2;

import milestone2.yell.AggressionLevel;
import milestone2.yell.Messenger;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Tim Malko
 * Lab 10: Milestone2.
 */
public class Milestone2Test {
    private static final Dimension DIMENSION = new Dimension(1440, 720);
    private static final int MIN_N = 2;
    private static final int MAX_N = 50;
    private static final String QUESTION = new String(("Enter lines number where n ∈ (" +
            MIN_N + ", " + MAX_N + "]").getBytes(), StandardCharsets.UTF_8);

    public static void main(String[] args) {
        int n = 0;
        AggressionLevel aggression = AggressionLevel.BENIGNANT;
        Messenger messenger = new Messenger(s -> showMessageDialog(null, s));
        do {
            if (!aggression.equals(AggressionLevel.BENIGNANT))
                messenger.message(aggression);
            //we getting angrier each time
            aggression = aggression.angry();
            String input = showInputDialog(QUESTION);
            // if user cancel or close window it will be null
            if (input == null) return;
            // try to parse to int
            try {
                n = Integer.parseInt(input);
            } catch (Exception ignored) {}
        } while (n <= MIN_N || n > MAX_N);
        //create a JFrame and DrawPanel, than show them
        JFrame frame = new Milestone2(n, DIMENSION);
        frame.setVisible(true);
    }

}
