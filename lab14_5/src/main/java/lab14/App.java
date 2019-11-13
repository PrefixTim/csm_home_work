package lab14;

/**
 * Tim Malko
 * cis 254
 * Craps fairness checker
 */
public class App {
    private static final int GAMES_TO_PLAY = 1_000_000;
    public static void main(String[] args) {
        //create craps ans other stuff
        Craps craps = new Craps();
        int[] won = new int[22];
        int[] lost = new int[22];
        long avrLength = 0;
        //pkay craps and save result
        for (int i = 0; i < GAMES_TO_PLAY; i++) {
            GameResult result = craps.play();
            craps.restart();
            avrLength += result.getLength();
            if (result.isWon())
                won[Math.min(21, result.getLength())] += 1;
            else 
                lost[Math.min(21, result.getLength())] += 1;
        }
        avrLength /= GAMES_TO_PLAY;
        //show results
        long gamesWon = printArray(won, "won");
        printArray(lost, "lost");
        System.out.printf("Chaises to win in craps is %.2f%%\n", (double) gamesWon*100/GAMES_TO_PLAY);
        System.out.printf("The average length is %d\n", avrLength);
    }

    /**
     * @param arr array of wins or loses to print
     * @param status verb for array "won" or "lost"
     * @return total number of "won" or "lost" games
     */
    private static long printArray(int[] arr, String status) {
        long total = 0;
        for (int i = 1; i < arr.length; i++) {
            total+=arr[i];
            System.out.printf("In %2d roll(s), %6d games %4s\n", i, arr[i], status);
        }
        System.out.printf("total game %s %6d\n", status, total);
        return total;
    }
}
