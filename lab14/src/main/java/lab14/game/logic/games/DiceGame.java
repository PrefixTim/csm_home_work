package lab14.game.logic.games;

import lab14.game.logic.dices.Dice;

import java.util.Collection;
import java.util.function.Function;

public interface DiceGame<T, R, D> {
    R play(T input);
    Boolean restart();
    Boolean isEnded();
    void setDices(Collection<Dice<D>> dices);
}
