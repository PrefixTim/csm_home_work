package lab11;

// Craps.java
// Craps class simulates the dice game craps.
// Your Comment Header Block
//

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Craps {
    // constants that represent common rolls of the dice
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

    private static final int MIN_N = 1;
    private static final int MAX_N = 1000;
    private static final String QUESTION = new String(("Enter your bet between[" +
            MIN_N + "$, %d$]").getBytes(), StandardCharsets.UTF_8);
    private static final Map<Status, List<String>> phrases = new HashMap<>();
    private static Map<AggressionLevel, List<String>> phrasesMap = new HashMap<>();
    private static int bankBalance = 1000;
    private static Random randomNumber = new Random(System.nanoTime());

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

    static {
        phrases.put(Status.CONTINUE, List.of("Oh, you're going for broke, huh?", "Aw c'mon, take a chance!"
                , "You're up big. Now's the time to cash in your chips!"));
        phrases.put(Status.LOST, List.of("You will be busted!", "Press F to pay respect", "Fatality",
                "You lose you money!", "Good boy! Please use our service  again!"));
        phrases.put(Status.WON, List.of("Well done. You won your life!", "Ups, There are a bug in the program." +
                "You supposed to lose", ""));
    }

    // plays one game of craps
    public static void main(String[] args) {
        Integer bet = requestBet();
        if (bet == null) return;
        int myPoint = 0; // point if no win or loss on first roll
        Status gameStatus; // can contain CONTINUE, WON or LOST
        int sumOfDice = rollDice(); // first roll of the dice
        // determine game status and point based on first roll
        switch (sumOfDice) {
            case SEVEN: // win with 7 on first roll
            case YO_LEVEN: // win with 11 on first roll
                gameStatus = Status.WON;
                break;
            case SNAKE_EYES: // lose with 2 on first roll
            case TREY: // lose with 3 on first roll
            case BOX_CARS: // lose with 12 on first roll
                gameStatus = Status.LOST;
                break;
            default: // did not win or lose, so remember point
                gameStatus = Status.CONTINUE; // game is not over
                myPoint = sumOfDice; // remember the point
                System.out.printf("Point is %d\n", myPoint);
                break; // optional at end of switch
        } // end switch
        // while game is not complete
        while (gameStatus == Status.CONTINUE) {// not WON or LOST
            chatter(gameStatus);
            sumOfDice = rollDice(); // roll dice again
            // determine game status
            if (sumOfDice == myPoint) // win by making point
                gameStatus = Status.WON;
            else if (sumOfDice == SEVEN) // lose by rolling 7 before point
                gameStatus = Status.LOST;
        } // end while
        chatter(gameStatus);
        // display won or lost message
        String s;
        if (gameStatus == Status.WON) {
            s = "Player wins";
            bankBalance += bet;
        } else {
            bankBalance -= bet;
            s = "Player loses " + (bankBalance == 0 ? "Sorry. You busted!" : "get lucky another time");

        }
        System.out.printf("Player %s. Bank: %d$", s, bankBalance);
    } // end main

    private static Integer requestBet() {
        int n = 0;
        AggressionLevel aggression = AggressionLevel.BENIGNANT;
        do {
            if (!aggression.equals(AggressionLevel.BENIGNANT)) {
                List<String> phrases = phrasesMap.get(aggression);
                showMessageDialog(null, phrases.get(randomNumber.nextInt(phrases.size())));
            }
            //we getting angrier each time
            aggression = aggression.angry();
            String input = showInputDialog(String.format(QUESTION, bankBalance));
            // if user cancel or close window it will be null
            if (input == null) return null;
            // try to parse to int
            try {
                n = Integer.parseInt(input);
            } catch (Exception ignored) {
            }
        } while (n < MIN_N || n > bankBalance);
        return n;
    }

    // roll dice, calculate sum and display results
    private static int rollDice() {
        // pick random die values
        int die1 = 1 + randomNumber.nextInt(6); // first die roll
        int die2 = 1 + randomNumber.nextInt(6); // second die roll
        int sum = die1 + die2; // sum of die values
        // display results of this roll
        System.out.printf("Player rolled %d + %d = %d\n",
                die1, die2, sum);
        return sum; // return sum of dice
    } // end method rollDice

    private static void chatter(Status status) {
        List strings = phrases.get(status);
        System.out.println("Craps: " + strings.get(randomNumber.nextInt(strings.size())));
    }

    // create random number generator for use in method rollDice private static final Random randomNumbers = new Random();
    // enumeration with constants that represent the game status
    private enum Status {CONTINUE, WON, LOST}
} // end class Craps