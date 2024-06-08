package it.uniba.app.Thompson.game.error;

/**
 * {@literal << Error >>}
 * Class to throw an error when the command is not found.
 */
public class PawnBlocked extends Exception {

    /**
     * Constructor for the class CommandNotFound.
     */
    public PawnBlocked() {
        super("PAWN_BLOCKED");
    }
}
