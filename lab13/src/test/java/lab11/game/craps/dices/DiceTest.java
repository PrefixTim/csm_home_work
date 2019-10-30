package lab11.game.craps.dices;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DiceTest {
    private Dice dice;
    private List outcomes;

    public DiceTest(Dice dice, List outcomes) {
        this.dice = dice;
        this.outcomes = outcomes;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> dices() {
        List values = List.of(1, 3, 5, 7);
        return List.of(new Object[][]{
                {new FairDice(3), List.of(1, 2, 3)},
                {new OneValueDice<>(true), List.of(true)},
                {new UnequalChancesSideDice<>(IntStream.range(0, 4).boxed()
                        .collect(toMap(values::get, List.of(1d, 2d, 3d, 1d)::get))), values},
                {new UnequalChancesSideDice<>(IntStream.range(0, 4)
                        .boxed().collect(toMap(values::get, List.of(0.5d, 0.2d, 0.3d, 0d)::get))), values}
        });
    }

    @Test
    public void rollDice() {
        for (int i = 0; i < outcomes.size(); i++)
            assert (outcomes.contains(dice.getRolled()));
    }

    @Test
    public void getRolled() {
        assertEquals(dice.rollDice(), dice.getRolled());
    }
}