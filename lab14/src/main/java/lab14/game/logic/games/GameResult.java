package lab14.game.logic.games;

public class GameResult {
    private boolean won;
    private int length;

    public GameResult(boolean won, int length) {
        this.won = won;
        this.length = length;
    }



    public boolean isWon() {
        return won;
    }

    public int getLength() {
        return length;
    }
}
