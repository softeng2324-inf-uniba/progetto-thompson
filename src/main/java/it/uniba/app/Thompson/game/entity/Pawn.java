package it.uniba.app.Thompson.game.entity;
import it.uniba.app.Thompson.game.util.PawnFigure;

/**
 * << Entity >>
 * Class Pawn.
 */
public final class Pawn {

    /**
     * Attributes of Pawn.
     */
    private PawnFigure figure;

    /**
     * Constructor for the class Pawn.
     * @param newFigure Figure of the pawn.
     */
    public Pawn(final PawnFigure newFigure) {
        figure = newFigure;
    }

    /**
     * Method to set the figure of the pawn.
     * @param pawnFigure Figure of the pawn
     */
    public void setFigure(final PawnFigure pawnFigure) {
        figure = pawnFigure;
    }

    /**
     * Method to get the figure of the pawn.
     * @return The figure of the pawn
     */
    public PawnFigure getFigure() {
        return figure;
    }
}
