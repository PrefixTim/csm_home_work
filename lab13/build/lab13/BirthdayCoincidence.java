package lab13;

import java.util.Random;

public class BirthdayCoincidence {
    private static final int year = 365; // days in one year in average
    private Random random = new Random(); // pseudorandom number generator

    /**
     * simulates one  BirthdayCoincidence experiment
     *
     * @return ans on which person Coincidence happened
     */
    public int simulate() {
        int ans = 0;
        boolean[] arr = new boolean[year];
        int day = random.nextInt(year);
        for (; !arr[day]; ans++) {
            arr[day] = true;
            day = random.nextInt(year);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.printf("one run ans id %d\n", new BirthdayCoincidence().simulate());
    }
}
