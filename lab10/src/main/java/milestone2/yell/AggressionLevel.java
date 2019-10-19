package milestone2.yell;

import java.util.List;

/**
 * have different aggression levels
 */
public enum AggressionLevel{
    BENIGNANT(
            "Please input a valid number.",
            "Nice try! Read the instruction and try again. I believe in you!"
    ),
    CALM(
            "Please input a valid number.",
            "Please Read the instructions!",
            "Invalid argument"
    ),
    OK("Read the damn prompt!"),
    DESPAIR(
            "Give up... Save me from this infinite pain... PLEASE,"
    ),
    GANDHI_S_FURRY(
            "Why do you do this to me? Please search deep within your soul and do what is right...",
            "It was IQ test. YOU Failed! Even ape-man've passed it"
    );

    private List<String> messages;

    AggressionLevel(String... messages) {
        this.messages = List.of(messages);
    }

    public AggressionLevel angry(){
        return AggressionLevel.values()[(this.ordinal()+1)%AggressionLevel.values().length];
    }

    public AggressionLevel calm() throws Exception {
        throw new Exception("CAN'T CALM");
    }

}
