package milestone2;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
    private static Map<AggressionLevel, List<String>> phrasesMap = new HashMap<>();

    static {
        phrasesMap.put(AggressionLevel.BENIGNANT, List.of("Please input a valid number.",
                "Nice try! Read the instruction and try again. I believe in you!"));
        phrasesMap.put(AggressionLevel.CALM, List.of(
                "Please input a valid number.",
                "Please Read the instructions!",
                "Invalid argument"
        ));
        phrasesMap.put(AggressionLevel.OK, List.of("Read the damn prompt!"));
        phrasesMap.put(AggressionLevel.DESPAIR, List.of(
                "Give up... Save me from this infinite pain... PLEASE,",
                "A time will come and you will bring butter to me"));
        phrasesMap.put(AggressionLevel.GANDHI_S_FURRY, List.of(
                "Why do you do this to me? Please search deep within your soul and do what is right...",
                "Leather bastard. My brothers from Boston will come for you",
                "It was IQ test. YOU Failed! Even ape-man've passed it"));
    }

    public static void main(String[] args) {
        int n = 0;
        AggressionLevel aggression = AggressionLevel.BENIGNANT;
        do {
            if (!aggression.equals(AggressionLevel.BENIGNANT)) {
                Random random = new Random(System.currentTimeMillis());
                List<String> phrases = phrasesMap.get(aggression);
                showMessageDialog(null, phrases.get(random.nextInt(phrases.size())));
            }
            //we getting angrier each time
            aggression = aggression.angry();
            String input = showInputDialog(QUESTION);
            // if user cancel or close window it will be null
            if (input == null) return;
            // try to parse to int
            try {
                n = Integer.parseInt(input);
            } catch (Exception ignored) {
            }
        } while (n <= MIN_N || n > MAX_N);
        //create a JFrame and DrawPanel, than show them
        JFrame frame = new Milestone2(n, DIMENSION);
        frame.setVisible(true);
    }
}
