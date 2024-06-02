package it.uniba.app.Thompson.game.error;

/**
 * {@literal << Error >>}
 * Class to throw an error when there is no active match.
 */
public class MatchNullError extends Exception {

    /**
     * Constructor for the class ExcessBlockedTileError.
     */
    public MatchNullError() {
        super("MATCH_IS_NULL");
    }
}
