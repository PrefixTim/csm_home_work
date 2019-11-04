package lab13;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class BirthdayCoincidence {
    private Random rand = new Random();
    private Set<Integer> dates = new HashSet<>();
    private Function<Integer, Void> resultProcessor;

    public BirthdayCoincidence(Function<Integer, Void> resultProcessor) {
        this.resultProcessor = resultProcessor;
    }

    public static void main(String[] args) {
        BirthdayCoincidence test = new BirthdayCoincidence(
                (Integer result) -> {
                    System.out.printf("Value is %d\n", result);
                    return null;
                });
        test.simulate();
    }

    public void simulate() {

            boolean[] arr = new boolean[365];
            int x = 0;
            int birth = rand.nextInt(365);
            while (!arr[birth]){
                x++;
                arr[birth]= true;
                birth = rand.nextInt(365);
            }
            resultProcessor.apply(x);
//        int date;
//        do {
//            date = rand.nextInt(365);
//        } while (dates.add(date));
//        resultProcessor.apply(dates.size());
//        dates.clear();
    }
}
