package lab14.game.logic.games;

public interface DiceGame<T, V> {
    T play(V input);
    Boolean restart();
    Boolean isEnded();
}
