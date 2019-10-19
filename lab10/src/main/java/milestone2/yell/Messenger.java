package milestone2.yell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Messenger {
    private static final List<String> MESSAGES;

    static {
        MESSAGES = new ArrayList<>();
        MESSAGES.add("Please input a valid number.");
        MESSAGES.add("Read the damn prompt!");
        MESSAGES.add("Give up... Save me from this infinite pain... PLEASE,");
        MESSAGES.add("Why do you do this to me? Please search deep within your soul and do what is right...");
        MESSAGES.add("It was IQ test. YOU Failed! Even ape-man've passed it");
        MESSAGES.add("To exit press a button");
    }

    private Random random = new Random(System.nanoTime());
    private Yeller yeller;

    public Messenger(Yeller yeller) {
        this.yeller = yeller;
    }

    /**
     * show user a message based on aggression level
     * (here message is a verb)
     *
     * @param level level of aggression
     */
    public void message(AggressionLevel level) {
        int message;
        switch (level) {
            case BENIGNANT:
            case CALM:
                message = 1;
                break;
            case OK:
                message = random.nextInt(2);
                break;
            case DESPAIR:
                message = 2;
                break;
            case GANDHI_S_FURRY:
                message = 3;
                break;
            default:
                message = 0;
        }
        yeller.yell(MESSAGES.get(message));
    }
}
