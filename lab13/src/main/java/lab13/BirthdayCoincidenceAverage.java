package lab13;

import java.util.Scanner;

/**
 * Tim Malko
 * Lab 10: Milestone2.
 */
public class BirthdayCoincidenceAverage {
    public static void main(String... args) {
        try (Scanner scanner = new Scanner(System.in)) { // scanner
            long ans = 0;
            long n = scanner.nextLong(); // read n
            BirthdayCoincidence experiment = new BirthdayCoincidence(); // create single BirthdayCoincidence
            for (int i = 0; i < n; i++) //for n
                ans += experiment.simulate(); //sum ans
            ans /= n; //div by n
            System.out.printf("for n = %d runs. the ans is %d.\n", n, ans); // show results
        }
    }
}