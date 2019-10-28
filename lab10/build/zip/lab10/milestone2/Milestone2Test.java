package milestone2;

import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;

/**
 * Tim Malko
 * Lab 10: Milestone2.
 */
public class Milestone2Test {
    private static final int WIDTH = 1440;
    private static final int HEIGHT = 720;
    private static final int MIN_N = 2;
    private static final int MAX_N = 50;
    private static final String QUESTION = new String(("Enter lines number where n ∈ (" +
            MIN_N + ", " + MAX_N + "]").getBytes(), StandardCharsets.UTF_8);
    private static final List MESSAGES = List.of(
            "Please input a valid number.",
            "Read the damn prompt!",
            "Give up... Save me from this infinite pain... PLEASE,",
            "Why do you do this to me? Please search deep within your soul and do what is right...",
            "It was IQ test. YOU Failed! Even ape-man've passed it");

    public static void main(String[] args) {
        //var n = 0;
        //var rand = new Random();
        int n = 0;
        Random rand = new Random();

        while (true) {
            String input = JOptionPane.showInputDialog(QUESTION);
            // if user cancel or close window it will be null
            if (input == null)
                return;
            // try to parse to int
            try { n = Integer.parseInt(input); } catch (Exception ignored) {}
            //yielding on user for mistake
            if (!(n > MIN_N && n <= MAX_N))
                JOptionPane.showMessageDialog(null, MESSAGES.get(rand.nextInt(MESSAGES.size())));
            else
                break;

        }
        //create a JFrame and DrawPanel, than show them
//        var frame = new Milestone2(n, WIDTH, HEIGHT);
        JFrame frame = new Milestone2(n, WIDTH, HEIGHT);
        frame.setVisible(true);
    }
}
