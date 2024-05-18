package it.uniba.app.Thompson.game.util;

/**
 * << Util >>
 * Class for the management of the visualization of the pawns in unicode.
 */
public final class UnicodePawn {

    /**
     * Pawn constructor.
     */
    private UnicodePawn() { }

    /**
     * @param pawn Visualization of the pawn
     * @return Return unicode pawn figure based off pawn parameter
     */
    public static String getPawnUnicode(final PawnFigure pawn) {
        switch (pawn) {
            case WHITE_PAWN -> {
                return "⛀";
            }
            case BLACK_PAWN -> {
                return "⛂";
            }
            default -> {
                return "\u001B[0m";
            }
        }
    }
}
