package it.uniba.app.Thompson.game.util;

/**
 * {@literal << Util >>}
 * Class for the management of the pawns in unicode.
 */
public final class UnicodePawn {

    /**
     * Constructor for the class UnicodePawn.
     */
    private UnicodePawn() { }

    /**
     * Method getPawnUnicode.
     * @param pawn Pawn figure of the returning unicode
     * @return Returns unicode pawn figure based off pawn parameter
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
