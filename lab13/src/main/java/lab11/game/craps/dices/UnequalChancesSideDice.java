package lab11.game.craps.dices;

import java.util.Map;


/**
 * Rolls a set of object with defined chances
 *
 * @param <T> is an object that will be rolled
 */
public class UnequalChancesSideDice<T> extends NSideDice<T> {
    private T rolled;
    /**
     * Map of rollObjects to normalized chances
     */
    private Map<T, Double> sidesChances;

    /**
     * chances are normalized by div by {@code total}
     *
     * @param sidesChances map of obj with chances
     */
    UnequalChancesSideDice(Map<T, Double> sidesChances) {
        super(sidesChances.size());
        double total = sidesChances.values().stream().reduce(0d, Double::sum);
//        sidesChances.forEach((t, v) -> sidesChances.put(t, v / total));
        final double[] previous = {0d};
        sidesChances.forEach((t, v) -> {
            previous[0] += v / total;
            sidesChances.put(t, previous[0]);
        });
        this.sidesChances = sidesChances;
        rollDice();
    }

    @Override
    public T rollDice() {
        double randN = getRandom().nextDouble();
        for (T t : sidesChances.keySet()) {
            if (randN < sidesChances.get(t)){
                setRolled(t);
                return t;
            }
        }
        throw new IllegalStateException("One is never reached");
    }

    @Override
    public T getRolled() {
        return rolled;
    }

    private void setRolled(T rolled) {
        this.rolled = rolled;
    }
}
