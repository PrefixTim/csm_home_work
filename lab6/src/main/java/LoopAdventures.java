/**
 * Tim Malko
 * CIS 254
 * Solution for lab 6
 */
public class LoopAdventures {
    /**
     * Prints n line with index of step 2^index and index!
     * @param args number of steps
     */
    public static void main(String[] args) {
        Long n = Long.parseLong("1000");
        Long powOf2 = 1L;
        Long fact = 1L;
        System.out.printf("%2s\t%10s\t%30s\n", "N", "N^2", "N!");
        System.out.printf("%2s\t%10s\t%30s\n", "--", "------", "--------------------------");
        for (Long i = 1L; i <= n; i++) {
            System.out.printf("%2d\t%10d\t%30d\n", i, powOf2, fact);
            powOf2 *= 2L;
            fact *= i;
        }
        System.out.println("Changing Int to Long allow to store bigger number, also it may be change to BigInteger to store more");
    }  
}
