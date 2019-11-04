package lab12;

import java.util.ArrayList;
import java.util.Random;

public abstract class Pro {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Random random = new Random();
        int avrg = 0;
        for (int i = 0; i < 800; i++) {
            int birth = random.nextInt(366);
            while (!arr.contains(birth)) {
                arr.add(birth);
                birth = random.nextInt(366);
            }
            avrg += arr.size();
            arr.clear();
        }
    }
}
