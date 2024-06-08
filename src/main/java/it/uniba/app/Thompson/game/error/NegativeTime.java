package it.uniba.app.Thompson.game.error;

/**
 * {@literal << Error >>}
 * Class to throw an error when there is no active match.
 */
public class NegativeTime extends Exception {

    /**
     * Constructor for the class MatchNull.
     */
    public NegativeTime() {
        super("TIME_IS_NEGATIVE");
    }
}
