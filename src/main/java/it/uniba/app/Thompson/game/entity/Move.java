package it.uniba.app.Thompson.game.entity;
import it.uniba.app.Thompson.game.util.MoveTypes;

/**
 * <<Entity>>
 * Class Move.
 */
public final class Move {

    /**
     * Attributes of Move.
     */
    @SuppressWarnings("FieldCanBeLocal")
    private MoveTypes moveTypes;
    @SuppressWarnings("FieldCanBeLocal")
    private char letter;
    @SuppressWarnings("FieldCanBeLocal")
    private char number;
    @SuppressWarnings("FieldCanBeLocal")
    private final boolean invalid = false;

    /**
     * Method to set the letter.
     * @param charLetter the letter
     */
    public void setLetter(final char charLetter) {
        this.letter = charLetter;
    }

    /**
     * Method to set the number.
     * @param setNumber the number
     */
    public void setNumber(final char setNumber) {
        this.number = setNumber;
    }

    /**
     * Method to set the move type.
     * @param typeOfMove the type of move
     */
    public void setMoveTypes(final MoveTypes typeOfMove) {
        this.moveTypes = typeOfMove;
    }

    /**
     * Method to see if the move is valid.
     * @return boolean
     */
    public boolean isMoveValid() {
        return !invalid;
    }

    private Move() {

    }
}
