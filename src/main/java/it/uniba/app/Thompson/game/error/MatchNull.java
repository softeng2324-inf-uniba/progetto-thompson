package it.uniba.app.Thompson.game.error;

/**
 * {@literal << Error >>}
 * Class to throw an error when there is no active match.
 */
public class MatchNull extends Exception {

    /**
     * Constructor for the class MatchNull.
     */
    public MatchNull() {
        super("MATCH_IS_NULL");
    }
}
