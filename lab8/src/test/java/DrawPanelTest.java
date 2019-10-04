import view.MainFrame;

import javax.swing.*;

/**
 * Tim Malko
 * CIS 254
 * ask user for n in ∈ (5, 70) and draw assigment
 */
public class DrawPanelTest {
    private static final String MESSAGE = "Enter lines number where n ∈ (5, 70)";

    public static void main(String[] args) {
        int n = 0;
        String message = MESSAGE;
        while (!((n > 5) && (n < 70))) {
            //asking user by diolog
            String input = JOptionPane.showInputDialog(message);
            if (input == null)
                return;
            try {
                n = Integer.parseInt(input);
            } catch (NumberFormatException ignore){
                message = MESSAGE + " !!!!!";
            }
        }
        new MainFrame(n).setVisible(true);
    }
}
