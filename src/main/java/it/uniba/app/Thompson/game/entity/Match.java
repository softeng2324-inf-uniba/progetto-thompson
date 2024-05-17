package it.uniba.app.Thompson.game.entity;
import java.util.Stack;

/**
 * <<Entity>>
 * Class Match.
 */
public class Match {

    /**
     * Attributes of Match.
     */
    private boolean onGoing = false;
    private final Stack<Move> moves = new Stack<>();

    /**
     * Method to get the Ongoing state of the match.
     * @return boolean
     */
    public boolean getOnGoing() {
        return this.onGoing;
    }
    /**
     *Method to set the match.
     *@param state the match
     */
    public void setOnGoing(final boolean state) {
        this.onGoing = state;
    }

    /**
     * Method to set the move.
     * @param mossa the move
     */
    public void setMove(final Move mossa) {
        this.moves.push(mossa);
    }
    /**
     * Method to get the moves.
     * @return the moves stack
     */
    public Stack<Move> getMosse() {
        return this.moves;
    }
}
