/*
 * AccountTest.java
 * Inputting and outputting floating-point numbers with Account objects.
 */
import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("type saving balance, than saving");
        Account acc = new Account(in.nextDouble(), in.nextDouble());
        System.out.println(acc.toString());
        System.out.println("Type amount to move from checking to saving");
        acc.moveFromCheckingToSavings(in.nextDouble());
        System.out.println(acc.toString());
        System.out.println("Type amount to move from saving to checking");
        acc.moveFromSavingsToChecking(in.nextDouble());
        System.out.println(acc.toString());
    }
}
