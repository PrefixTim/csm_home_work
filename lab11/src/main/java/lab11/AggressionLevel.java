package lab11;

/**
 * have different aggression levels
 */
public enum AggressionLevel {
    BENIGNANT,
    CALM,
    OK,
    DESPAIR,
    GANDHI_S_FURRY;

    public AggressionLevel angry() {
        return AggressionLevel.values()[Math.min(this.ordinal() + 1, AggressionLevel.values().length - 1)];
    }

    public AggressionLevel calm() throws Exception {
        throw new Exception("CAN'T CALM");
    }

}
