package lab13;

import java.util.*;

public class BirthdayCoincidenceAverage {
    private long ans = 0;

    public void simulateParallel(long n, int threads) {
        long runs = (n + threads - 1) /threads;
        List<Thread> simulations = new ArrayList<>();
        for (int i = 0; i < threads; i++) {
            Thread t = new Thread(() -> {
                final long[] total = {0};
                BirthdayCoincidence test = new BirthdayCoincidence((Integer result) ->
                { total[0] += result; return null; });
                for (int j = 0; j < runs; j++) {
                    test.simulate();
                }
                addToAns(total[0]);
            });
            simulations.add(t);
            t.start();
        }
        for (Thread t : simulations) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("the average value is %d\n", ans/(runs*threads));
    }

    public synchronized void addToAns(long addition) {
        this.ans += addition;
    }

    public static void  singleList(long n) {
        ArrayList<Integer> arr = new ArrayList<>();
        Random random = new Random();
        int avrg = 0;
        for (int i = 0; i < n; i++) {
            int birth = random.nextInt(365);
            while (!arr.contains(birth)){
                arr.add(birth);
                birth = random.nextInt(365);
            }
            avrg += arr.size();
            arr.clear();
        }
        System.out.println(avrg/n);
    }

    public static void  singleArray(long n) {
        Random random = new Random();
        int avrg = 0;
        for (int i = 0; i < n; i++) {
            boolean[] arr = new boolean[365];
            int x = 0;
            int birth = random.nextInt(365);
            while (!arr[birth]){
                x++;
                arr[birth]= true;
                birth = random.nextInt(365);
            }
            avrg += x;
        }
        System.out.println(avrg/n);

    }

    public static void  singleSet(long n) {
        Set<Integer> set = new HashSet<>();
        Random random = new Random();
        int avrg = 0;
        for (int i = 0; i < n; i++) {
            int birth;
            do {
                birth = random.nextInt(365);
            } while (set.add(birth));
            avrg += set.size();
            set.clear();
        }
        System.out.println(avrg/n);

    }

    public static void main(String[] args) {
        long n =16_000_000L;
        long start = System.currentTimeMillis();
        new  BirthdayCoincidenceAverage().simulateParallel(n, Runtime.getRuntime().availableProcessors());
        System.out.printf("Multi Thread Process took time: %d\n", System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        new  BirthdayCoincidenceAverage().simulateParallel(n, 1);
        System.out.printf("Single Thread Process took time: %d\n", System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        singleList(n);
        System.out.printf("Single List Process took time: %d\n", System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        singleSet(n);
        System.out.printf("Single set Process took time: %d\n", System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        singleArray(n);
        System.out.printf("Single Array Process took time: %d\n", System.currentTimeMillis() - start);
    }
}
