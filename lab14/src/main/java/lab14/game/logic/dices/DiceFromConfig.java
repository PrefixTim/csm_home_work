package lab14.game.logic.dices;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.util.List;
import java.util.stream.Collectors;

public class DiceFromConfig {
    public static Dice<Integer> getDiceFromConfig(Config config) throws IllegalArgumentException {
        if ( !(config.hasPath("dice") && config.hasPath("dice.type")))
            throw new IllegalArgumentException("No Dice config found");
        config = config.getConfig("dice");
        Dice<Integer> dice;
        switch (DICES.valueOf(config.getString("type"))) {
            case CHIT:
                dice = new ChitDice<>(config.getInt("num"));
                break;
            case REGULAR:
                dice = new RegularDice(config.getInt("sides"));
                break;
            default:
                throw new IllegalArgumentException("Wrong type of Dice");
        }
        return dice;
    }

    public static List<Dice<Integer>> getDicesFromConfig(Config config) {
        return config.getConfigList("dices").stream().map(DiceFromConfig::getDiceFromConfig).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Config config = ConfigFactory.parseResources("app.conf");
        System.out.println(config.getString("game1.title"));
        System.out.println(getDicesFromConfig(config.getConfig("game1")));
    }

    private  enum DICES{CHIT, REGULAR};
}
