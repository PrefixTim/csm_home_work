package lab13;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

public class BirthdayCoincidenceAverage extends BirthdayCoincidence {
    private static final int year = 365;
    private final boolean isMultiThread;

    public BirthdayCoincidenceAverage(Function<Random, Integer> simulate, boolean multiThread) {
        super(simulate);
        isMultiThread = multiThread;
    }

    public static void main(String[] args) {
        Map<String, Function<Random, Integer>> solutions = new HashMap<>();
        solutions.put("boolArray", (Random random) -> {
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
        solutions.put("intList", (Random random) -> {
            List<Integer> arr = new ArrayList<>();
            int day = random.nextInt(year);
            while (!arr.contains(day)) {
                arr.add(day);
                day = random.nextInt(year);
            }
            return arr.size();
        });
        solutions.put("intSet", (Random random) -> {
            Set<Integer> arr = new HashSet<>();
            int day;
            do day = random.nextInt(year); while (arr.add(day));
            return arr.size();
        });
        try (Scanner scanner = new Scanner(System.in)) {
            long n;
            do {
                n = scanner.nextLong();
                for (String s : solutions.keySet()) {
                    test(n, s, solutions.get(s), false);
                    test(n, s, solutions.get(s), true);
                }
            } while (n > 0);
        }
    }

    public static void test(long n, String name, Function<Random, Integer> simulate, boolean multiThread) {
        long current = System.currentTimeMillis();
        System.out.printf("%s ans is %f, %sThread time took %d\n",
                name,
                new BirthdayCoincidenceAverage(simulate, multiThread).simulate(n),
                multiThread ? "Multi" : "single",
                System.currentTimeMillis() - current);
    }

    @Override
    public double simulate(long n) {
        int threadsN = isMultiThread ? Runtime.getRuntime().availableProcessors() : 1;
        AtomicLong ans = new AtomicLong(0);
        AtomicLong counter = new AtomicLong(0);
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < threadsN; i++) {
            Thread t = new Thread(() -> {
                long result = 0;
                Random random = new Random();
                while (counter.getAndIncrement() < n)
                    result += simulate.apply(random);
                ans.addAndGet(result);
            });
            threads.add(t);
            t.start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return ((double) ans.get()) / n;
    }
}
