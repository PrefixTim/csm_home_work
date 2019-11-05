package lab13;

import java.util.Random;
import java.util.function.Function;

public class BirthdayCoincidence{
    private static final int year = 365;
    protected final Function<Random, Integer> simulate;

    public BirthdayCoincidence(Function<Random, Integer> simulate) {
        this.simulate = simulate;
    }

    public static void main(String[] args) {
        BirthdayCoincidence test = new BirthdayCoincidence((Random random) -> {
            int ans = 0;
            boolean[] arr = new boolean[year];
            int day = random.nextInt(year);
            while (!arr[day]) {
                arr[day] = true;
                ans++;
                day = random.nextInt(year);
            }
            return ans;
        });
        System.out.printf("Answer is %f\n", test.simulate(1));
    }

    public double simulate(long n) {
        long ans = 0;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            ans += simulate.apply(random);
        }
        return ((double) ans) / n;
    }
}
