package it.uniba.app.Thompson.game.entity;
import it.uniba.app.Thompson.game.util.PawnFigure;

/**
 * {@literal << Entity >>}
 * Class representing the pawn entity.
 */
public final class PawnE {

    /**
     * Attributes of the class PawnE.
     */
    private PawnFigure figure;

    /**
     * Constructor for the class PawnE.
     * @param newFigure The figure of the pawn.
     */
    public PawnE(final PawnFigure newFigure) {
        figure = newFigure;
    }

    /**
     * Method setFigure.
     * @param pawnFigure The figure of the pawn
     */
    public void setFigure(final PawnFigure pawnFigure) {
        figure = pawnFigure;
    }

    /**
     * Method getFigure.
     * @return figure The figure of the pawn
     */
    public PawnFigure getFigure() {
        return figure;
    }
}
